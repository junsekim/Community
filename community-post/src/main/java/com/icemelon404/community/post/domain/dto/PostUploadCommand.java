package com.icemelon404.community.post.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
@Builder
public class PostUploadCommand {
    private final long authorId;
    private final String content;
    private final List<ImageData> uploadImages;
}
