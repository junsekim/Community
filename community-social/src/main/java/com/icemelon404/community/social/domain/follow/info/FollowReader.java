package com.icemelon404.community.social.domain.follow.info;

import com.icemelon404.community.commons.dto.AscPagedRequest;
import com.icemelon404.community.social.domain.follow.entity.Follow;

import java.util.List;

public interface FollowReader {
    List<Follow> getFollowers(long followee, AscPagedRequest<Long> request);
    List<Follow> getFollows(long follower, AscPagedRequest<Long> request);
}
