package com.icemelon404.community.dispatcher.infra;

import com.icemelon404.community.dispatcher.domain.push.FeedElement;
import com.icemelon404.community.dispatcher.domain.push.FeedPusher;
import com.icemelon404.community.feed.proto.*;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;


@RequiredArgsConstructor
public class GrpcFeedPusher implements FeedPusher {

    private final SocialFeedServiceGrpc.SocialFeedServiceStub stub;

    @Override
    public Mono<Void> pushFeed(FeedElement elem) {
        return Mono.<PushResult>create(sink -> {
            FeedPushRequest request = FeedPushRequest.newBuilder().addUserWithPost(userWithPost(elem)).build();
            stub.pushFeed(request, new MonoStreamObserver<>(sink));
        }).then();
    }

    private UserWithPost userWithPost(FeedElement element) {
        return UserWithPost.newBuilder().setPostId(element.getPostId()).setFeedOwnerId(element.getFeedOwnerId()).build();
    }
}
