package com.icemelon404.community.post.domain.feed;

import com.icemelon404.community.post.domain.dto.PostDetails;

import java.util.List;

public interface PostDetailFetchService {
    List<PostDetails> requestPosts(List<Long> postIds);
}
