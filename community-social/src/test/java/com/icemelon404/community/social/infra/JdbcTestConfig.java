package com.icemelon404.community.social.infra;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class JdbcTestConfig {

    @Bean
    public DataSource testSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/community?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC");
        config.setUsername("community");
        config.setPassword("wnstjr7");
        return new HikariDataSource(config);
    }

    @Bean
    public JdbcTemplate template(DataSource source) {
        return new JdbcTemplate(source);
    }

    @Bean
    public JdbcFollowRepository repository(JdbcTemplate source) {
        return new JdbcFollowRepository(source);
    }

    @Bean
    public JdbcRequestRepository requestRepository(JdbcTemplate source) {
        return new JdbcRequestRepository(source);
    }

    @Bean
    public TransactionManager manager(DataSource source) {
        return new DataSourceTransactionManager(source);
    }
}
