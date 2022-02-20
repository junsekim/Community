package com.icemelon404.community.post.domain.upload;

import com.icemelon404.community.post.domain.entity.Post;

public interface PostStore {
    Post savePost(Post post);
}
