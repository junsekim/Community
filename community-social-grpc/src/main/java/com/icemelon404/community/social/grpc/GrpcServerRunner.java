package com.icemelon404.community.social.grpc;

import io.grpc.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

@RequiredArgsConstructor
public class GrpcServerRunner implements ApplicationRunner {

    private final Server server;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        server.start();
        server.awaitTermination();
    }
}
