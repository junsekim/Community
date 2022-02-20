package com.icemelon404.community.dispatcher.config;

import com.icemelon404.community.dispatcher.api.KafkaPagingApi;
import com.icemelon404.community.dispatcher.api.KafkaPushApi;
import com.icemelon404.community.dispatcher.domain.PagedAuthorInfo;
import com.icemelon404.community.dispatcher.domain.paging.AuthorInfo;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    @Bean
    public KafkaAdmin kafkaAdmin(@Value("${kafka.bootstrap-servers}") String servers) {
        Map<String, Object> config = new HashMap<>();
        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        return new KafkaAdmin(config);
    }

    @Bean
    public NewTopic authorInfoTopic(@Value("${kafka.topic.author-info}") String topicName,
                                    @Value("${kafka.topic.author-info.replica}") int replica,
                                    @Value("${kafka.topic.author-info.partition}") int partition) {
        return TopicBuilder.name(topicName)
                .partitions(partition)
                .replicas(replica)
                .compact()
                .build();
    }

    @Bean
    public NewTopic pagedAuthorInfoTopic(@Value("${kafka.topic.paged-author-info}") String topicName,
                                         @Value("${kafka.topic.paged-author-info.replica}") int replica,
                                         @Value("${kafka.topic.paged-author-info.partition}") int partition) {
        return TopicBuilder.name(topicName)
                .partitions(partition)
                .replicas(replica)
                .compact()
                .build();
    }

    public Map<String, Object> consumerProperties(String servers) {
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "dispatcher");
        return config;
    }



    public Map<String, Object> producerConfig(String servers) {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return props;
    }

    public ProducerFactory<Long, String> pagedAuthorInfoProducerFactory(String servers) {
        return new DefaultKafkaProducerFactory<>(producerConfig(servers));
    }

    @Bean
    public KafkaTemplate<Long, String> pagedAuthorInfoTemplate(@Value("${kafka.bootstrap-servers}") String servers,
                                                                        @Value("${kafka.topic.paged-author-info}") String topicName) {
        KafkaTemplate<Long, String> ret = new KafkaTemplate<>(pagedAuthorInfoProducerFactory(servers));
        ret.setDefaultTopic(topicName);
        return ret;
    }

    @Bean
    public ConcurrentMessageListenerContainer<Long, String>
    pagingListenerContainerFactory(@Value("${kafka.consumer.author-info.concurrency}") int concurrency,
                                   @Value("${kafka.bootstrap-servers}") String servers,
                                   @Value("${kafka.topic.author-info}") String topicName,
                                   KafkaPagingApi api) {
        ConcurrentMessageListenerContainer<Long, String> factory =
                new ConcurrentMessageListenerContainer<>(consumerFactory(servers), containerProperties(topicName, api));
        factory.setConcurrency(concurrency);
        return factory;
    }

    @Bean
    public ConcurrentMessageListenerContainer<Long, String>
    concurrentListenerContainerFactory(@Value("${kafka.consumer.paged-author-info.concurrency}") int concurrency,
                                       @Value("${kafka.bootstrap-servers}") String servers,
                                       @Value("${kafka.topic.paged-author-info}") String topicName,
                                       KafkaPushApi api) {
        ConcurrentMessageListenerContainer<Long, String> factory =
                new ConcurrentMessageListenerContainer<>(consumerFactory(servers), containerProperties(topicName, api));
        factory.setConcurrency(concurrency);
        return factory;
    }

    public ContainerProperties containerProperties(String topicName, MessageListener<?,?> listener) {
        ContainerProperties properties = new ContainerProperties(topicName);
        properties.setAsyncAcks(true);
        properties.setMessageListener(listener);
        properties.setAckMode(ContainerProperties.AckMode.MANUAL);
        return properties;
    }

    public ConsumerFactory<Long, String> consumerFactory(String servers) {
        return new DefaultKafkaConsumerFactory<>(consumerProperties(servers));
    }

}
