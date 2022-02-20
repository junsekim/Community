package com.icemelon404.community.dispatcher.config;

import com.icemelon404.community.dispatcher.domain.PagedAuthorInfo;
import com.icemelon404.community.dispatcher.infra.GrpcFeedPusher;
import com.icemelon404.community.dispatcher.infra.GrpcFollowerCountFetcher;
import com.icemelon404.community.dispatcher.infra.GrpcFollowerFetcher;
import com.icemelon404.community.dispatcher.infra.KafkaPagedAuthorInfoPusher;
import com.icemelon404.community.feed.proto.SocialFeedServiceGrpc;
import com.icemelon404.community.social.proto.FollowCountServiceGrpc;
import com.icemelon404.community.social.proto.FollowerFetchServiceGrpc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class InfraConfig {

    @Bean
    public GrpcFeedPusher pusher(SocialFeedServiceGrpc.SocialFeedServiceStub stub) {
        return new GrpcFeedPusher(stub);
    }

    @Bean
    public KafkaPagedAuthorInfoPusher authorInfoPusher(KafkaTemplate<Long, String> template) {
        return new KafkaPagedAuthorInfoPusher(template);
    }

    @Bean
    public GrpcFollowerCountFetcher countFetcher(FollowCountServiceGrpc.FollowCountServiceStub stub) {
        return new GrpcFollowerCountFetcher(stub);
    }

    @Bean
    public GrpcFollowerFetcher followerFetcher(FollowerFetchServiceGrpc.FollowerFetchServiceStub  stub) {
        return new GrpcFollowerFetcher(stub);
    }
}
