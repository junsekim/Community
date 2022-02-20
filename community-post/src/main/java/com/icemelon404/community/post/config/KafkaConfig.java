package com.icemelon404.community.post.config;

import com.icemelon404.community.post.domain.push.AuthorInfo;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    public Map<String, Object> producerConfig(String servers) {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return props;
    }

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


    public ProducerFactory<Long, String> authorInfoProducerFactory(String servers) {
        return new DefaultKafkaProducerFactory<>(producerConfig(servers));
    }

    @Bean
    public KafkaTemplate<Long, String> pagedAuthorInfoTemplate(@Value("${kafka.bootstrap-servers}") String servers,
                                                                   @Value("${kafka.topic.author-info}") String topicName) {
        KafkaTemplate<Long, String> ret =  new KafkaTemplate<>(authorInfoProducerFactory(servers));
        ret.setDefaultTopic(topicName);
        return ret;
    }

}
