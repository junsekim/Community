package com.icemelon404.community.post.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class PostPreview {
    private final long postId;
    private final long authorId;
    private final String thumbnailImageId;
}
