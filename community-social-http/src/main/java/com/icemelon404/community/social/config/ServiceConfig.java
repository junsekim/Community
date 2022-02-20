package com.icemelon404.community.social.config;


import com.icemelon404.community.social.domain.follow.core.FollowService;
import com.icemelon404.community.social.domain.follow.core.FollowStore;
import com.icemelon404.community.social.domain.follow.count.*;
import com.icemelon404.community.social.domain.follow.info.FollowInfoFetchService;
import com.icemelon404.community.social.domain.follow.info.FollowReader;
import com.icemelon404.community.social.domain.request.*;
import com.icemelon404.community.social.domain.follow.core.FollowEventPushHandler;
import com.icemelon404.community.social.domain.follow.core.FollowServiceImpl;
import com.icemelon404.community.social.domain.follow.info.FollowInfoFetchServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public FollowCountService countService(FollowCountReader reader) {
        return new FollowCountServiceImpl(reader);
    }

    @Bean
    public FollowInfoFetchService infoFetchService(FollowReader reader) {
        return new FollowInfoFetchServiceImpl(reader);
    }

    @Bean
    public FollowService followService(FollowStore store, FollowEventPushHandler handler) {
        return new FollowServiceImpl(store, handler);
    }

    @Bean
    public FollowRequestFetchService requestFetchService(RequestReader reader) {
        return new FollowRequestFetchServiceImpl(reader);
    }

    @Bean
    public FollowRequestService requestService(RequestStore store, FollowService service) {
        return new FollowRequestServiceImpl(store, service);
    }

    @Bean
    public FollowEventPushHandler countPushHandler(FollowCountModifier modifier) {
        return new FollowCountModifyHandler(modifier);
    }
}
