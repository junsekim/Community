package com.icemelon404.community.post.domain.feed;

import com.icemelon404.community.commons.dto.PagedRequest;
import com.icemelon404.community.post.domain.dto.PostDetails;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FeedDetailsServiceImpl implements FeedDetailsService {

    private final FeedPostIdFetcher feedPostIdFetcher;
    private final PostDetailFetchService postDetailFetchService;


    @Override
    public List<PostDetails> requestFeed(long ownerId, PagedRequest<Long> pagedRequest) {
        List<Long> feedPostIds = feedPostIdFetcher.requestPostIds(ownerId, pagedRequest);
        return postDetailFetchService.requestPosts(feedPostIds);
    }

}
