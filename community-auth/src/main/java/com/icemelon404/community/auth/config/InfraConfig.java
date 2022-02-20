package com.icemelon404.community.auth.config;

import com.icemelon404.community.auth.domain.encoder.PasswordEncoder;
import com.icemelon404.community.auth.domain.register.RegisterEventPushHandler;
import com.icemelon404.community.auth.domain.encoder.BcryptPasswordEncoder;
import com.icemelon404.community.auth.infa.JpaUserRepository;
import com.icemelon404.community.auth.infa.JpaUserRepositoryAdapter;
import com.icemelon404.community.auth.infa.RegisterEventPushHandlerMock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfraConfig {

    @Bean
    public PasswordEncoder encoder() {
        return new BcryptPasswordEncoder();
    }

    @Bean
    public JpaUserRepositoryAdapter repositoryAdapter(JpaUserRepository repository) {
        return new JpaUserRepositoryAdapter(repository);
    }

    @Bean
    public RegisterEventPushHandler mock() {
        return new RegisterEventPushHandlerMock();
    }
}
