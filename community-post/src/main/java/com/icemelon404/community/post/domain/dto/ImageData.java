package com.icemelon404.community.post.domain.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.InputStream;

@Getter
@RequiredArgsConstructor
public abstract class ImageData {
    @Getter
    private final ImageType imageType;
    @Getter
    private final long imageSize;

    public abstract InputStream imageInputStream();
}
