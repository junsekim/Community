package com.icemelon404.community.post.domain.upload;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PostInfo {
    private final long id;
    private final boolean isNewPost;
    private final long author;
    private final String content;
}
