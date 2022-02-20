package com.icemelon404.community.social.domain.follow.core;

import com.icemelon404.community.social.domain.dto.FollowCommand;

public interface FollowService {
    void addFollow(FollowCommand command);
    void removeFollow(FollowCommand command);
    boolean hasFollow(FollowCommand command);
}
