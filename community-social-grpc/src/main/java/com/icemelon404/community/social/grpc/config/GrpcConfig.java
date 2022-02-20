package com.icemelon404.community.social.grpc.config;

import com.icemelon404.community.social.domain.follow.core.FollowService;
import com.icemelon404.community.social.domain.follow.count.FollowCountService;
import com.icemelon404.community.social.domain.follow.paged.PagedFollowerFetchService;
import com.icemelon404.community.social.grpc.GrpcServerRunner;
import com.icemelon404.community.social.grpc.api.FollowCheckApi;
import com.icemelon404.community.social.grpc.api.FollowCountApi;
import com.icemelon404.community.social.grpc.api.FollowerFetchApi;
import io.grpc.Server;
import io.grpc.netty.InternalProtocolNegotiators;
import io.grpc.netty.NettyServerBuilder;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;

@Configuration
public class GrpcConfig {

    @Bean
    public Server server(@Value("${server.port}") int port,
                         FollowService followService,
                         PagedFollowerFetchService fetchService,
                         FollowCountService countService) {
        return NettyServerBuilder
                .forPort(port)
                .protocolNegotiator(InternalProtocolNegotiators.serverPlaintext())
                .executor(Executors.newFixedThreadPool(150))
                .bossEventLoopGroup(new NioEventLoopGroup(1))
                .workerEventLoopGroup(new NioEventLoopGroup(2))
                .channelType(NioServerSocketChannel.class)
                .addService(new FollowCheckApi(followService))
                .addService(new FollowerFetchApi(fetchService))
                .addService(new FollowCountApi(countService))
                .build();
    }

    @Bean
    public GrpcServerRunner runner(Server server) {
        return new GrpcServerRunner(server);
    }
}
