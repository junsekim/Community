package com.icemelon404.community.social.grpc.api;

import com.icemelon404.community.social.domain.follow.core.FollowService;
import com.icemelon404.community.social.domain.dto.FollowCommand;
import com.icemelon404.community.social.proto.FollowCheckServiceGrpc;
import com.icemelon404.community.social.proto.FollowInfo;
import com.icemelon404.community.social.proto.FollowStatus;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class FollowCheckApi extends FollowCheckServiceGrpc.FollowCheckServiceImplBase {

    private final FollowService followService;

    @Override
    public void checkFollow(FollowInfo request, StreamObserver<FollowStatus> responseObserver) {
        try {
            log.debug("followCheck request received");
            boolean ret = followService.hasFollow(new FollowCommand(request.getFollower(), request.getFollowee()));
            responseObserver.onNext(FollowStatus.newBuilder().setIsFollowing(ret).build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }
}
