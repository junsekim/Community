package com.icemelon404.community.social.grpc.api;

import com.icemelon404.community.social.domain.follow.count.FollowCountService;
import com.icemelon404.community.social.proto.FollowCount;
import com.icemelon404.community.social.proto.FollowCountServiceGrpc;
import com.icemelon404.community.social.proto.User;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class FollowCountApi extends FollowCountServiceGrpc.FollowCountServiceImplBase {

    private final FollowCountService service;

    @Override
    public void fetchCount(User request, StreamObserver<FollowCount> responseObserver) {
        log.debug("fetchCount request received");
        responseObserver.onNext(convert(service.getCount(request.getUserId())));
        responseObserver.onCompleted();
    }

    private FollowCount convert(com.icemelon404.community.social.domain.dto.FollowCount count) {
        return FollowCount.newBuilder()
                .setFollowCount(count.getFollow())
                .setFollowerCount(count.getFollower())
                .build();
    }
}
