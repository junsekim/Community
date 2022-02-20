package com.icemelon404.community.feed.repository;

import com.icemelon404.community.commons.dto.PagedRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

public interface FeedRepository {
    Flux<Long> getFeed(long feedOwnerId, PagedRequest<Long> request);
    Mono<Void> pushFeed(Collection<UserWithPost> authorInfos);
}
