package com.icemelon404.community.post.config;

import com.icemelon404.community.feed.proto.PrivateFeedServiceGrpc;
import com.icemelon404.community.feed.proto.SocialFeedServiceGrpc;
import com.icemelon404.community.post.domain.image.PostImageService;
import com.icemelon404.community.post.domain.push.AuthorInfo;
import com.icemelon404.community.post.domain.push.AuthorInfoPushHandler;
import com.icemelon404.community.post.domain.push.AuthorInfoPushHandlerComposite;
import com.icemelon404.community.post.infra.feed.grpc.GrpcPrivateFeedRepository;
import com.icemelon404.community.post.infra.feed.grpc.GrpcSocialFeedRepository;
import com.icemelon404.community.post.infra.feed.kafka.KafkaAuthorInfoPushHandler;
import com.icemelon404.community.post.infra.image.LocalFileImageService;
import com.icemelon404.community.post.infra.post.JpaPostRepository;
import com.icemelon404.community.post.infra.post.JpaPostRepositoryAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.List;


@Configuration
public class InfraConfig {

    @Bean
    public PostImageService imageService() {
        return new LocalFileImageService("./image");
    }

    @Bean
    public JpaPostRepositoryAdapter postRepositoryAdapter(JpaPostRepository repository) {
        return new JpaPostRepositoryAdapter(repository);
    }

    @Bean
    @Qualifier("social")
    public GrpcSocialFeedRepository socialFeedRepository(SocialFeedServiceGrpc.SocialFeedServiceBlockingStub stub) {
        return new GrpcSocialFeedRepository(stub);
    }

    @Bean
    @Qualifier("private")
    public GrpcPrivateFeedRepository privateFeedRepository(PrivateFeedServiceGrpc.PrivateFeedServiceBlockingStub stub) {
        return new GrpcPrivateFeedRepository(stub);
    }

    @Bean
    @Qualifier("kafka")
    public KafkaAuthorInfoPushHandler authorInfoPushHandler(KafkaTemplate<Long, String> template) {
        return new KafkaAuthorInfoPushHandler(template);
    }

    @Bean
    @Qualifier("composite")
    public AuthorInfoPushHandler compositeHandler(GrpcPrivateFeedRepository repository, KafkaAuthorInfoPushHandler pusher) {
        return new AuthorInfoPushHandlerComposite(List.of(repository, pusher));
    }

}
