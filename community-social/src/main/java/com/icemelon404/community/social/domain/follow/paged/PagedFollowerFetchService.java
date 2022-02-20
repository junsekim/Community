package com.icemelon404.community.social.domain.follow.paged;

import com.icemelon404.community.commons.dto.ConcretePagedRequest;

import java.util.List;

public interface PagedFollowerFetchService {
    List<Long> getFollowers(long followeeId, ConcretePagedRequest request);
}
