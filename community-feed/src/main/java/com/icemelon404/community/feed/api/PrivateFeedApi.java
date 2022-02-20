package com.icemelon404.community.feed.api;


import com.icemelon404.community.feed.proto.*;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class PrivateFeedApi extends PrivateFeedServiceGrpc.PrivateFeedServiceImplBase {

    private final CommonFeedApi feedService;

    @Override
    public void getFeed(FeedRequest request, StreamObserver<FeedResponse> responseObserver) {
        log.debug("getFeed 요청 수신");
        feedService.getFeed(request, responseObserver);
    }

    @Override
    public void pushFeed(FeedPushRequest request, StreamObserver<PushResult> responseObserver) {
        log.debug("pushFeed 요청 수신");
        feedService.pushFeed(request, responseObserver);
    }
}
