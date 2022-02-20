package com.icemelon404.community.feed.repository;

import com.icemelon404.community.commons.dto.PagedRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.cassandra.core.cql.ReactiveCqlTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

@RequiredArgsConstructor
public class CassandraFeedRepository implements FeedRepository {

    private final String requestAboveQuery;
    private final String requestBelowQuery;
    private final String pushQuery;
    private final ReactiveCqlTemplate template;

    public CassandraFeedRepository(String tableName, ReactiveCqlTemplate template) {
        this.template = template;
        this.requestAboveQuery = "SELECT * FROM " + tableName + " WHERE id= ? AND post_id > ? ORDER BY post_id ASC LIMIT ?";
        this.requestBelowQuery = "SELECT * FROM " + tableName + " WHERE id=? AND post_id < ? ORDER BY post_id DESC LIMIT ?";
        this.pushQuery = "INSERT INTO " + tableName + " (id, post_id) VALUES(?, ?)";
    }

    @Override
    public Flux<Long> getFeed(long ownerId, PagedRequest<Long> request) {
        return switch (request.getRequestDir()) {
            case UPPER -> template.queryForFlux(requestAboveQuery, Long.class, ownerId, request.getBoundary(), request.getSize());
            case LOWER -> template.queryForFlux(requestBelowQuery, Long.class, ownerId, request.getBoundary(), request.getSize());
        };
    }

    @Override
    public Mono<Void> pushFeed(Collection<UserWithPost> infos) {
        return infos.stream()
                .map(info -> template.execute(pushQuery, info.getOwnerId(), info.getPostId()).then())
                .reduce((reduced, target) -> Mono.zip(reduced, target).then())
                .orElse(Mono.empty());
    }
}
