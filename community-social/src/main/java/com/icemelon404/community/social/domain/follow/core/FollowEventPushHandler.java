package com.icemelon404.community.social.domain.follow.core;

import com.icemelon404.community.social.domain.dto.FollowCommand;

public interface FollowEventPushHandler {
    void onFollow(FollowCommand command);
    void onUnfollow(FollowCommand command);
}
