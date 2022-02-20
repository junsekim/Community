package com.icemelon404.community.dispatcher.domain.push;

import reactor.core.publisher.Mono;

public interface FeedPusher {
    Mono<Void> pushFeed(FeedElement elem);
}
