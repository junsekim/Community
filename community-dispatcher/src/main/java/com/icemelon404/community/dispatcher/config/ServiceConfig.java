package com.icemelon404.community.dispatcher.config;

import com.icemelon404.community.dispatcher.domain.paging.FollowerCountFetcher;
import com.icemelon404.community.dispatcher.domain.paging.PagedAuthorInfoPusher;
import com.icemelon404.community.dispatcher.domain.paging.PagingService;
import com.icemelon404.community.dispatcher.domain.push.FeedPusher;
import com.icemelon404.community.dispatcher.domain.push.PagedFollowerFetcher;
import com.icemelon404.community.dispatcher.domain.push.PushService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public PushService pushService(PagedFollowerFetcher fetcher, FeedPusher pusher) {
        return new PushService(fetcher, pusher);
    }

    @Bean
    public PagingService pagingService(FollowerCountFetcher countFetcher,
                                       PagedAuthorInfoPusher pusher,
                                       @Value("${author-info.page.size}") int pageSize) {
        return new PagingService(countFetcher, pusher, pageSize);
    }
}
