package com.icemelon404.community.feed.api;

import com.icemelon404.community.commons.dto.Direction;
import com.icemelon404.community.commons.dto.PagedRequest;
import com.icemelon404.community.feed.proto.FeedPushRequest;
import com.icemelon404.community.feed.proto.FeedRequest;
import com.icemelon404.community.feed.proto.FeedResponse;
import com.icemelon404.community.feed.proto.PushResult;
import com.icemelon404.community.feed.repository.FeedRepository;
import com.icemelon404.community.feed.repository.UserWithPost;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;

import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
public class CommonFeedApi {

    private final FeedRepository repository;

    public void getFeed(FeedRequest request, StreamObserver<FeedResponse> responseObserver) {
        log.debug("Get feed request accepted");
        Flux<Long> postIds = repository.getFeed(request.getFeedOwnerId(), pagedRequestOf(request));
        FeedResponse.Builder builder = FeedResponse.newBuilder();
        Disposable disposable = postIds.subscribe(postId-> {
            log.debug("P");
            builder.addPostId(postId);
        }, (err) -> {
            log.error("Error on get feed request",err);
            responseObserver.onError(err);
        }, ()-> {
            responseObserver.onNext(builder.build());
            responseObserver.onCompleted();
            log.debug("Get feed response sent");
        });
    }

    public void pushFeed(FeedPushRequest request, StreamObserver<PushResult> responseObserver) {
        log.debug("Push feed request accepted");
        repository.pushFeed(authorInfoListOf(request)).subscribe(null, err -> {
            log.error("Error on get feed request",err);
            responseObserver.onError(err);
        }, ()-> {
            responseObserver.onNext(PushResult.newBuilder().setIsSuccess(true).build());
            responseObserver.onCompleted();
            log.debug("Push feed ack sent");
        });
    }

    private Collection<UserWithPost> authorInfoListOf(FeedPushRequest request) {
        return request.getUserWithPostList().stream()
                .map(this::authorInfoOf)
                .collect(Collectors.toList());
    }

    private UserWithPost authorInfoOf(com.icemelon404.community.feed.proto.UserWithPost authorInfo) {
        return new UserWithPost(authorInfo.getFeedOwnerId(), authorInfo.getPostId());
    }

    private PagedRequest<Long> pagedRequestOf(FeedRequest request) {
        return new PagedRequest<>(request.getBoundary(), directionOf(request), request.getSize());
    }

    private Direction directionOf(FeedRequest request) {
        return switch (request.getDirection()) {
            case UPPER -> Direction.UPPER;
            case LOWER -> Direction.LOWER;
            case UNRECOGNIZED -> throw new IllegalArgumentException("알 수 없는 요청입니다");
        };
    }
}
