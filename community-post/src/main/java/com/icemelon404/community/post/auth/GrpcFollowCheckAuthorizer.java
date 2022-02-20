package com.icemelon404.community.post.auth;

import com.icemelon404.community.commons.exception.ForbiddenActionException;
import com.icemelon404.community.social.proto.FollowCheckServiceGrpc;
import com.icemelon404.community.social.proto.FollowInfo;
import com.icemelon404.community.social.proto.FollowStatus;
import com.icemelon404.community.user.UserInfo;
import com.icemelon404.community.user.UserToUserAuthorizer;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GrpcFollowCheckAuthorizer implements UserToUserAuthorizer {

    private final FollowCheckServiceGrpc.FollowCheckServiceBlockingStub stub;

    @Override
    public void checkAuthorized(UserInfo requester, long targetUserId) {
        try {
            FollowStatus status = stub.checkFollow(FollowInfo.newBuilder().setFollowee(targetUserId).setFollowee(requester.getId()).build());
            if (!status.getIsFollowing())
                throw new ForbiddenActionException(requester.getId() + " -> " + targetUserId + " 는 팔로우 관계가 아닙니다");
        } catch (Exception e) {
            throw new ForbiddenActionException("인증 불가", e);
        }
    }
}
