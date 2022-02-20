package com.icemelon404.community.post.api;

import com.icemelon404.community.post.domain.image.PostImageService;
import com.icemelon404.community.post.domain.dto.ImageData;
import com.icemelon404.community.post.domain.dto.ImageType;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
public class ImageAPI {

    private final PostImageService imageService;

    @GetMapping(name= "/image/feed/{imageId}")
    public ResponseEntity<InputStreamResource> getImage(@RequestParam("imageId") String imageId) {
        ImageData data = imageService.getImageById(imageId);
        return ResponseEntity.ok()
                .contentLength(data.getImageSize())
                .contentType(mediaTypeOf(data))
                .body(new InputStreamResource(data.imageInputStream()));
    }

    private MediaType mediaTypeOf(ImageData data) {
        if (data.getImageType() == ImageType.JPEG)
            return MediaType.IMAGE_JPEG;
        else if (data.getImageType() == ImageType.PNG)
            return MediaType.IMAGE_PNG;
        throw new IllegalStateException("MediaType 변환에 실패하였습니다");
    }

}
