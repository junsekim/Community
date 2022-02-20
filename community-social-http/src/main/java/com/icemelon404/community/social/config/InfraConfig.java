package com.icemelon404.community.social.config;

import com.icemelon404.community.social.infra.JdbcRequestRepository;
import com.icemelon404.community.social.infra.JdbcCountRepository;
import com.icemelon404.community.social.infra.JdbcFollowRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class InfraConfig {

    @Bean
    public JdbcCountRepository countRepository(JdbcTemplate template) {
        return new JdbcCountRepository(template);
    }

    @Bean
    public JdbcFollowRepository followRepository(JdbcTemplate template) {
        return new JdbcFollowRepository(template);
    }

    @Bean
    public JdbcRequestRepository requestRepository(JdbcTemplate template) {
        return new JdbcRequestRepository(template);
    }
}
