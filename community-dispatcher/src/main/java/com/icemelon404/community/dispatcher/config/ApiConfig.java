package com.icemelon404.community.dispatcher.config;

import com.icemelon404.community.dispatcher.api.KafkaPagingApi;
import com.icemelon404.community.dispatcher.api.KafkaPushApi;
import com.icemelon404.community.dispatcher.domain.paging.PagingService;
import com.icemelon404.community.dispatcher.domain.push.PushService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {

    @Bean
    public KafkaPagingApi pagingApi(PagingService service) {
        return new KafkaPagingApi(service);
    }

    @Bean
    public KafkaPushApi pushApi(PushService service) {
        return new KafkaPushApi(service);
    }
}
