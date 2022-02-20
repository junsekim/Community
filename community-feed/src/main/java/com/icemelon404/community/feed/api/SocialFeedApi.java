package com.icemelon404.community.feed.api;

import com.icemelon404.community.feed.proto.*;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SocialFeedApi extends SocialFeedServiceGrpc.SocialFeedServiceImplBase {

    private final CommonFeedApi service;

    @Override
    public void getFeed(FeedRequest request, StreamObserver<FeedResponse> responseObserver) {
        service.getFeed(request, responseObserver);
    }

    @Override
    public void pushFeed(FeedPushRequest request, StreamObserver<PushResult> responseObserver) {
        service.pushFeed(request, responseObserver);
    }
}
