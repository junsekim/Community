package com.icemelon404.community.social.domain.follow.info;

import com.icemelon404.community.commons.dto.AscPagedRequest;
import com.icemelon404.community.social.domain.dto.FollowInfo;

import java.util.List;

public interface FollowInfoFetchService {
    List<FollowInfo> getFollowers(long followee, AscPagedRequest<Long> request);
    List<FollowInfo> getFollows(long follower, AscPagedRequest<Long> request);
}
