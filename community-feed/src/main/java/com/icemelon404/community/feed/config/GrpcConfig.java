package com.icemelon404.community.feed.config;

import com.icemelon404.community.feed.api.CommonFeedApi;
import com.icemelon404.community.feed.GrpcServerRunner;
import com.icemelon404.community.feed.api.PrivateFeedApi;
import com.icemelon404.community.feed.api.SocialFeedApi;
import com.icemelon404.community.feed.repository.FeedRepository;
import io.grpc.Server;
import io.grpc.netty.InternalProtocolNegotiators;
import io.grpc.netty.NettyServerBuilder;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class GrpcConfig {

    @Bean
    public PrivateFeedApi privateFeedAPI(@Qualifier("private") FeedRepository repository) {
        return new PrivateFeedApi(new CommonFeedApi(repository));
    }

    @Bean
    public SocialFeedApi socialFeedAPI(@Qualifier("social") FeedRepository repository) {
        return new SocialFeedApi(new CommonFeedApi(repository));
    }

    @Bean
    public Server server(@Value("${server.port}") int port,
                         SocialFeedApi socialApi,
                         PrivateFeedApi privateApi) {
        return NettyServerBuilder
                .forPort(port)
                .protocolNegotiator(InternalProtocolNegotiators.serverPlaintext())
                .directExecutor()
                .bossEventLoopGroup(new NioEventLoopGroup(2))
                .workerEventLoopGroup(new NioEventLoopGroup(8))
                .channelType(NioServerSocketChannel.class)
                .addService(privateApi)
                .addService(socialApi)
                .build();
    }

    @Bean
    public GrpcServerRunner runner(Server server) {
        return new GrpcServerRunner(server);
    }
}
