package com.icemelon404.community.post.infra.post;

import com.icemelon404.community.post.domain.entity.Post;
import com.icemelon404.community.post.domain.upload.PostStore;
import com.icemelon404.community.post.domain.view.PostReader;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class JpaPostRepositoryAdapter implements PostReader, PostStore {

    private final JpaPostRepository jpaPostRepository;

    @Override
    public List<Post> findPostByIds(List<Long> postIds) {
        return jpaPostRepository.findAllById(postIds);
    }

    @Override
    public Optional<Post> findPostById(long postId) {
        return jpaPostRepository.findById(postId);
    }

    @Override
    public Post savePost(Post post) {
        return jpaPostRepository.save(post);
    }

}
