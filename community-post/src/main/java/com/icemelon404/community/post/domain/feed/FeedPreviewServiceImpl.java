package com.icemelon404.community.post.domain.feed;

import com.icemelon404.community.commons.dto.PagedRequest;
import com.icemelon404.community.post.domain.dto.PostPreview;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FeedPreviewServiceImpl implements FeedPreviewService {

    private final FeedPostIdFetcher feedPostIdFetcher;
    private final PostPreviewFetchService postPreviewFetchService;

    @Override
    public List<PostPreview> requestPreview(long ownerId, PagedRequest<Long> pagedRequest) {
        List<Long> feedPostIds = feedPostIdFetcher.requestPostIds(ownerId, pagedRequest);
        return postPreviewFetchService.requestPosts(feedPostIds);
    }
}
