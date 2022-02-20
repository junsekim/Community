package com.icemelon404.community.social.domain.request;

import com.icemelon404.community.social.domain.dto.FollowCommand;

public interface FollowRequestService {
    void request(FollowCommand relation);
    void accept(FollowCommand relation);
    void cancel(FollowCommand relation);
}
