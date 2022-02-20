package com.icemelon404.community.user.config;

import com.icemelon404.community.user.UserInfoExtractor;
import com.icemelon404.community.user.auth.RequireAuthInterceptor;
import com.icemelon404.community.user.resolver.UserArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig extends WebMvcConfigurationSupport {

    private final UserInfoExtractor extractor;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new UserArgumentResolver(extractor));
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequireAuthInterceptor(extractor)).addPathPatterns("/**");
    }
}
