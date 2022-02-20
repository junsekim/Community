package com.icemelon404.community.post.domain.feed;

import com.icemelon404.community.commons.dto.PagedRequest;

import java.util.List;

public interface FeedPostIdFetcher {
    List<Long> requestPostIds(long ownerId, PagedRequest<Long> request);
}
