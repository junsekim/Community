package com.icemelon404.community.post.domain.image;

import com.icemelon404.community.post.domain.dto.ImageData;

import java.util.List;

public interface PostImageService {
    List<String> uploadAndGetIds(List<ImageData> images);
    List<ImageData> getImageListByIds(List<String> imageUrls);
    ImageData getImageById(String imageId);
}
