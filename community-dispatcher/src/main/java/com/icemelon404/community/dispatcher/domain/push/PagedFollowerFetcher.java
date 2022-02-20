package com.icemelon404.community.dispatcher.domain.push;

import com.icemelon404.community.commons.dto.ConcretePagedRequest;
import reactor.core.publisher.Flux;

public interface PagedFollowerFetcher {
    Flux<Long> getFollowers(long followee, ConcretePagedRequest request);
}
