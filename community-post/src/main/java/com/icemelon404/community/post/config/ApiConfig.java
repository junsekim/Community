package com.icemelon404.community.post.config;

import com.icemelon404.community.post.auth.GrpcFollowCheckAuthorizer;
import com.icemelon404.community.social.proto.FollowCheckServiceGrpc;
import com.icemelon404.community.user.UserToUserAuthorizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {

    @Bean
    public UserToUserAuthorizer authorizer(FollowCheckServiceGrpc.FollowCheckServiceBlockingStub stub) {
        return new GrpcFollowCheckAuthorizer(stub);
    }
}
