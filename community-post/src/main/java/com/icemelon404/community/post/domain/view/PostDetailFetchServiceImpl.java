package com.icemelon404.community.post.domain.view;

import com.icemelon404.community.post.domain.feed.PostDetailFetchService;
import com.icemelon404.community.post.domain.dto.PostDetails;
import com.icemelon404.community.post.domain.entity.Post;
import com.icemelon404.community.post.domain.entity.PostImage;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class PostDetailFetchServiceImpl implements PostDetailFetchService {

    private final PostReader repository;

    @Override
    public List<PostDetails> requestPosts(List<Long> postIds) {
        List<Post> entities = repository.findPostByIds(postIds);
        return entities
                .stream()
                .map(this::toPostInfo)
                .collect(Collectors.toList());
    }

    private PostDetails toPostInfo(Post it) {
        return PostDetails.builder()
                .postId(it.getId())
                .authorId(it.getAuthorId())
                .content(it.getContent())
                .imageUrls(imageUrlsOf(it))
                .build();
    }

    private List<String> imageUrlsOf(Post post) {
        return post.getImages()
                .stream()
                .map(PostImage::getImageId)
                .collect(Collectors.toList());
    }


}
