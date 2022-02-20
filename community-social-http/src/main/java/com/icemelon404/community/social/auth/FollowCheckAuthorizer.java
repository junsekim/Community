package com.icemelon404.community.social.auth;

import com.icemelon404.community.commons.exception.ForbiddenActionException;
import com.icemelon404.community.social.domain.follow.core.FollowService;
import com.icemelon404.community.social.domain.dto.FollowCommand;
import com.icemelon404.community.user.UserInfo;
import com.icemelon404.community.user.UserToUserAuthorizer;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FollowCheckAuthorizer implements UserToUserAuthorizer {

    private final FollowService service;

    @Override
    public void checkAuthorized(UserInfo requester, long targetUserId) {
        if (!service.hasFollow(new FollowCommand(requester.getId(), targetUserId)))
            throw new ForbiddenActionException("팔로워가 아닙니다");
    }
}
