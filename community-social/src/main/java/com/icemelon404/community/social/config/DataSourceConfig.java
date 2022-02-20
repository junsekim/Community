package com.icemelon404.community.social.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource testSource(HikariConfig config) {
        return new HikariDataSource(config);
    }

    @Bean
    public HikariConfig config(@Value("${spring.datasource.url}") String url,
                               @Value("${spring.datasource.driver-class-name}") String driverClass,
                               @Value("${spring.datasource.username}") String userName,
                               @Value("${spring.datasource.password}") String password) {
        HikariConfig config = new HikariConfig();
        config.setUsername(userName);
        config.setDriverClassName(driverClass);
        config.setJdbcUrl(url);
        config.setPassword(password);
        return config;
    }
}
