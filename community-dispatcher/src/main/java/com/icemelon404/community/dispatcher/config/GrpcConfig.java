package com.icemelon404.community.dispatcher.config;

import com.icemelon404.community.feed.proto.SocialFeedServiceGrpc;
import com.icemelon404.community.grpc.common.DiscoveryClientNameResolverProvider;
import com.icemelon404.community.social.proto.FollowCountServiceGrpc;
import com.icemelon404.community.social.proto.FollowerFetchServiceGrpc;
import com.netflix.discovery.EurekaClient;
import io.grpc.ManagedChannel;
import io.grpc.netty.NettyChannelBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcConfig {

    @Bean
    @Qualifier("social")
    public ManagedChannel socialChannel(DiscoveryClientNameResolverProvider provider) {
        return NettyChannelBuilder
                .forTarget("discover://social-grpc")
                .defaultLoadBalancingPolicy("round_robin")
                .usePlaintext()
                .nameResolverFactory(provider)
                .build();
    }

    @Bean
    @Qualifier("feed")
    public ManagedChannel feedChannel(DiscoveryClientNameResolverProvider provider) {
        return NettyChannelBuilder
                .forTarget("discover://feed")
                .defaultLoadBalancingPolicy("round_robin")
                .usePlaintext()
                .nameResolverFactory(provider)
                .build();
    }

    @Bean
    public DiscoveryClientNameResolverProvider nameResolverProvider(EurekaClient client) {
        return new DiscoveryClientNameResolverProvider(client);
    }

    @Bean
    public FollowCountServiceGrpc.FollowCountServiceStub countStub(@Qualifier("social") ManagedChannel channel) {
        return FollowCountServiceGrpc.newStub(channel);
    }

    @Bean
    public SocialFeedServiceGrpc.SocialFeedServiceStub feedStub(@Qualifier("feed")  ManagedChannel channel) {
        return SocialFeedServiceGrpc.newStub(channel);
    }

    @Bean
    public FollowerFetchServiceGrpc.FollowerFetchServiceStub followerStub(@Qualifier("social") ManagedChannel channel) {
        return FollowerFetchServiceGrpc.newStub(channel);
    }
}
