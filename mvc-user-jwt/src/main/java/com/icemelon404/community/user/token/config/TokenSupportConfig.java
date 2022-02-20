package com.icemelon404.community.user.token.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icemelon404.community.user.token.HttpTokenSupport;
import com.icemelon404.community.user.token.jwt.JwtTokenProvider;
import com.icemelon404.community.user.token.TokenProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TokenSupportConfig {

    @Bean
    public HttpTokenSupport support(TokenProvider provider) {
        return new HttpTokenSupport(provider, "Authorization", "BEARER");
    }

    @Bean
    public JwtTokenProvider jwtTokenProvider(@Value("${jwt.secret}") String secretKey, ObjectMapper mapper) {
        return new JwtTokenProvider(secretKey, mapper);
    }
}
