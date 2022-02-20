package com.icemelon404.community.auth.config;

import com.icemelon404.community.auth.domain.login.LoginService;
import com.icemelon404.community.auth.domain.encoder.PasswordEncoder;
import com.icemelon404.community.auth.domain.register.RegisterService;
import com.icemelon404.community.auth.domain.login.LoginServiceImpl;
import com.icemelon404.community.auth.domain.login.UserReader;
import com.icemelon404.community.auth.domain.register.RegisterEventPushHandler;
import com.icemelon404.community.auth.domain.register.RegisterServiceImpl;
import com.icemelon404.community.auth.domain.register.UserStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public LoginService loginService(UserReader reader, PasswordEncoder encoder) {
        return new LoginServiceImpl(reader, encoder);
    }

    @Bean
    public RegisterService registerService(UserStore store, RegisterEventPushHandler handler, PasswordEncoder encoder) {
        return new RegisterServiceImpl(store, handler, encoder);
    }
}
