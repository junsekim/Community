package com.icemelon404.community.post.domain.feed;

import com.icemelon404.community.commons.dto.PagedRequest;
import com.icemelon404.community.post.domain.dto.PostPreview;

import java.util.List;

public interface FeedPreviewService {
    List<PostPreview> requestPreview(long ownerId, PagedRequest<Long> pagedRequest);
}
