package com.icemelon404.community.feed.config;

import com.datastax.oss.driver.api.core.CqlSession;
import com.icemelon404.community.feed.repository.CassandraFeedRepository;
import com.icemelon404.community.feed.repository.FeedRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.ReactiveSession;
import org.springframework.data.cassandra.core.cql.ReactiveCqlTemplate;

@Configuration
public class CassandraConfig {

    @Bean
    public ReactiveCqlTemplate template(ReactiveSession session) {
        return new ReactiveCqlTemplate(session);
    }

    @Bean
    @Qualifier("private")
    public FeedRepository privateFeedRepo(ReactiveCqlTemplate template) {
        return new CassandraFeedRepository("private_feed", template);
    }

    @Bean
    @Qualifier("social")
    public FeedRepository socialFeedRepo(ReactiveCqlTemplate template) {
        return new CassandraFeedRepository("social_feed", template);
    }

}
