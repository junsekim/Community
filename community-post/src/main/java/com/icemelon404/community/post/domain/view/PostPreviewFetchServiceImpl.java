package com.icemelon404.community.post.domain.view;

import com.icemelon404.community.post.domain.dto.PostPreview;
import com.icemelon404.community.post.domain.entity.Post;
import com.icemelon404.community.post.domain.feed.PostPreviewFetchService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class PostPreviewFetchServiceImpl implements PostPreviewFetchService {

    private final PostReader repository;

    @Override
    public List<PostPreview> requestPosts(List<Long> postIds) {
        List<Post> posts = repository.findPostByIds(postIds);
        return posts
                .stream()
                .map(this::toPostPreview)
                .collect(Collectors.toList());
    }

    private PostPreview toPostPreview(Post post) {
        return PostPreview.builder()
                .authorId(post.getAuthorId())
                .postId(post.getId())
                .thumbnailImageId(thumbnailImageId(post))
                .build();
    }

    private String thumbnailImageId(Post post) {
        return post.getImages().get(0).getImageId();
    }
}
