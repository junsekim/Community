package com.icemelon404.community.social.domain.follow.count;

import com.icemelon404.community.social.domain.dto.FollowCount;

public interface FollowCountReader {
    FollowCount getFollowCount(long userId);
}
