package com.icemelon404.community.post.domain.feed;

import com.icemelon404.community.commons.dto.PagedRequest;
import com.icemelon404.community.post.domain.dto.PostDetails;

import java.util.List;

public interface FeedDetailsService {
    List<PostDetails> requestFeed(long ownerId, PagedRequest<Long> pagedRequest);
}
