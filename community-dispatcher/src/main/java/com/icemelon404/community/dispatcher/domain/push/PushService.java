package com.icemelon404.community.dispatcher.domain.push;

import com.icemelon404.community.dispatcher.domain.PagedAuthorInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
public class PushService {

    private final PagedFollowerFetcher fetcher;
    private final FeedPusher pusher;

    public Mono<Void> dispatchPostIdToFollowers(PagedAuthorInfo authorAndPost) {
        long authorId = authorAndPost.getAuthorInfo().getAuthorId();
        long postId = authorAndPost.getAuthorInfo().getPostId();
        Flux<Long> followerIds = fetcher.getFollowers(authorId, authorAndPost.getRequest());
        return followerIds.flatMap(followerId -> tryPush(new FeedElement(followerId, postId))).then();
    }

    private Mono<Void> tryPush(FeedElement element) {
        return pusher.pushFeed(element)
                .doOnError(e-> log.error("피드 푸쉬 실패; follower id: {}, post id: {}", element.getFeedOwnerId(), element.getPostId()));
    }
}
