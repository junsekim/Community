package com.icemelon404.community.post.domain.view;

import com.icemelon404.community.post.domain.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostReader {
    List<Post> findPostByIds(List<Long> postIds);
    Optional<Post> findPostById(long postId);
}
