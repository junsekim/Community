package com.icemelon404.community.post.domain.feed;

import com.icemelon404.community.post.domain.dto.PostPreview;

import java.util.List;

public interface PostPreviewFetchService {
    List<PostPreview> requestPosts(List<Long> postIds);
}
