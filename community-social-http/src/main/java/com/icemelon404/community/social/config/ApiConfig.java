package com.icemelon404.community.social.config;

import com.icemelon404.community.social.auth.FollowCheckAuthorizer;
import com.icemelon404.community.social.domain.follow.core.FollowService;
import com.icemelon404.community.user.UserToUserAuthorizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApiConfig {

    @Bean
    public UserToUserAuthorizer authorizer(FollowService service) {
        return new FollowCheckAuthorizer(service);
    }
}
