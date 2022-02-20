package com.icemelon404.community.dispatcher.infra;

import com.icemelon404.community.commons.dto.ConcretePagedRequest;
import com.icemelon404.community.dispatcher.domain.push.PagedFollowerFetcher;
import com.icemelon404.community.social.proto.Follower;
import com.icemelon404.community.social.proto.FollowerFetchServiceGrpc;
import com.icemelon404.community.social.proto.FollowerRequest;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class GrpcFollowerFetcher implements PagedFollowerFetcher {

    private final FollowerFetchServiceGrpc.FollowerFetchServiceStub stub;

    @Override
    public Flux<Long> getFollowers(long followee, ConcretePagedRequest request) {
        Flux<Follower> followers =
                Flux.create(sink -> stub.fetchFollowers(requestOf(followee, request), new FluxStreamObserver<>(sink)));
        return followers.map(Follower::getId);
    }

    private FollowerRequest requestOf(long followee, ConcretePagedRequest request) {
        return FollowerRequest.newBuilder()
                .setFollowee(followee)
                .setPageSize(request.getTotalPage())
                .setPageIndex(request.getRequestPage())
                .build();
    }
}
