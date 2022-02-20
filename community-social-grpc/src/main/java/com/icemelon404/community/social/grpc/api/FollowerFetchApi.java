package com.icemelon404.community.social.grpc.api;

import com.icemelon404.community.commons.dto.ConcretePagedRequest;
import com.icemelon404.community.social.domain.follow.paged.PagedFollowerFetchService;
import com.icemelon404.community.social.proto.Follower;
import com.icemelon404.community.social.proto.FollowerFetchServiceGrpc;
import com.icemelon404.community.social.proto.FollowerRequest;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class FollowerFetchApi extends FollowerFetchServiceGrpc.FollowerFetchServiceImplBase {

    private final PagedFollowerFetchService service;

    @Override
    public void fetchFollowers(FollowerRequest request, StreamObserver<Follower> responseObserver) {
        try {
            log.debug("fetchFollower request received");
            List<Long> ret = service.getFollowers(request.getFollowee(), new ConcretePagedRequest(request.getPageSize(), request.getPageIndex()));
            for (long followerId : ret)
                responseObserver.onNext(Follower.newBuilder().setId(followerId).build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }
}
