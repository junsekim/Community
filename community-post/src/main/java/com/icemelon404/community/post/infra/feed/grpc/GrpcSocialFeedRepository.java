package com.icemelon404.community.post.infra.feed.grpc;

import com.icemelon404.community.commons.dto.PagedRequest;
import com.icemelon404.community.commons.exception.ServerError;
import com.icemelon404.community.feed.proto.Direction;
import com.icemelon404.community.feed.proto.FeedRequest;
import com.icemelon404.community.feed.proto.SocialFeedServiceGrpc;
import com.icemelon404.community.post.domain.feed.FeedPostIdFetcher;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GrpcSocialFeedRepository implements FeedPostIdFetcher {

    private final SocialFeedServiceGrpc.SocialFeedServiceBlockingStub stub;

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

}
