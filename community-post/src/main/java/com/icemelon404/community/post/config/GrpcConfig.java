package com.icemelon404.community.post.config;

import com.icemelon404.community.feed.proto.PrivateFeedServiceGrpc;
import com.icemelon404.community.feed.proto.SocialFeedServiceGrpc;
import com.icemelon404.community.grpc.common.DiscoveryClientNameResolverProvider;
import com.icemelon404.community.social.proto.FollowCheckServiceGrpc;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import io.grpc.ManagedChannel;
import io.grpc.netty.NettyChannelBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcConfig {

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
    @Qualifier("social")
    public ManagedChannel socialChannel(DiscoveryClientNameResolverProvider provider) {
        return NettyChannelBuilder
                .forTarget("discover://social")
                .defaultLoadBalancingPolicy("round_robin")
                .usePlaintext()
                .nameResolverFactory(provider)
                .build();
    }


    @Bean
    public PrivateFeedServiceGrpc.PrivateFeedServiceBlockingStub privateFeedStub(@Qualifier("feed") ManagedChannel channel) {
        return PrivateFeedServiceGrpc.newBlockingStub(channel);
    }

    @Bean
    public SocialFeedServiceGrpc.SocialFeedServiceBlockingStub socialFeedStub(@Qualifier("feed") ManagedChannel channel) {
        return SocialFeedServiceGrpc.newBlockingStub(channel);
    }

    @Bean
    public DiscoveryClientNameResolverProvider provider(EurekaClient client) {
        return new DiscoveryClientNameResolverProvider(client);
    }

    @Bean
    public FollowCheckServiceGrpc.FollowCheckServiceBlockingStub socialStub(@Qualifier("social") ManagedChannel channel) {
        return FollowCheckServiceGrpc.newBlockingStub(channel);
    }
}
