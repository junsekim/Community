package com.icemelon404.community.post.infra.feed.grpc;

import com.icemelon404.community.commons.dto.PagedRequest;
import com.icemelon404.community.commons.exception.ServerError;
import com.icemelon404.community.feed.proto.*;
import com.icemelon404.community.post.domain.feed.FeedPostIdFetcher;
import com.icemelon404.community.post.domain.push.AuthorInfo;
import com.icemelon404.community.post.domain.push.AuthorInfoPushHandler;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GrpcPrivateFeedRepository implements FeedPostIdFetcher, AuthorInfoPushHandler {

    private final PrivateFeedServiceGrpc.PrivateFeedServiceBlockingStub stub;

    @Override
    public List<Long> requestPostIds(long ownerId, PagedRequest<Long> request) {
        try {
            return stub.getFeed(feedRequestOf(ownerId, request)).getPostIdList();
        } catch (Exception e) {
            throw new ServerError("Grpc 통신 중 오류 발생",e);
        }
    }

    private FeedRequest feedRequestOf(long ownerId, PagedRequest<Long> request) {
        return FeedRequest.newBuilder()
                .setFeedOwnerId(ownerId)
                .setBoundary(request.getBoundary())
                .setDirection(directionOf(request)).build();
    }

    private Direction directionOf(PagedRequest<Long> request) {
        return switch (request.getRequestDir()) {
            case UPPER -> Direction.UPPER;
            case LOWER -> Direction.LOWER;
        };
    }

    @Override
    public void pushAuthorInfo(AuthorInfo info) {
        if (!tryPush(info).getIsSuccess())
            throw new ServerError("Grpc 통신 중 오류가 발생하였습니다");
    }

    private PushResult tryPush(AuthorInfo info) {
        try {
            return stub.pushFeed(pushRequestOf(info));
        } catch(Exception e) {
            throw new ServerError("Grpc 통신 중 오류가 발생하였습니다", e);
        }
    }

    private FeedPushRequest pushRequestOf(AuthorInfo info) {
        return FeedPushRequest.newBuilder()
                .addUserWithPost(userWithPost(info))
                .build();
    }

    private UserWithPost userWithPost(AuthorInfo info) {
        return UserWithPost.newBuilder()
                .setFeedOwnerId(info.getAuthorId())
                .setPostId(info.getPostId())
                .build();
    }
}
