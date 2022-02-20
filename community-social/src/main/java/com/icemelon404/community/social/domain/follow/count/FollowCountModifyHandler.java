package com.icemelon404.community.social.domain.follow.count;

import com.icemelon404.community.social.domain.dto.FollowCommand;
import com.icemelon404.community.social.domain.follow.core.FollowEventPushHandler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FollowCountModifyHandler implements FollowEventPushHandler {

    private final FollowCountModifier modifier;

    @Override
    public void onFollow(FollowCommand command) {
        modifier.modifyFollowCount(command.getFollower(), 1);
        modifier.modifyFollowerCount(command.getFollowee(), 1);
    }

    @Override
    public void onUnfollow(FollowCommand command) {
        modifier.modifyFollowCount(command.getFollower(), -1);
        modifier.modifyFollowerCount(command.getFollowee(), -1);
    }
}
