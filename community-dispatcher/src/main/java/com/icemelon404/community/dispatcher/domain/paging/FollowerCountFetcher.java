package com.icemelon404.community.dispatcher.domain.paging;

import reactor.core.publisher.Mono;

public interface FollowerCountFetcher {
    Mono<Integer> fetchFollowerCount(long followee);
}
