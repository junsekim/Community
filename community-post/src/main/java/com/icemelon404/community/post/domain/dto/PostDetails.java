package com.icemelon404.community.post.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class PostDetails {
    private final long postId;
    private final long authorId;
    private final String content;
    private final List<String> imageUrls;
}
