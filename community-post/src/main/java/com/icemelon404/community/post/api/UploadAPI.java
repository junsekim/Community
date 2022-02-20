package com.icemelon404.community.post.api;

import com.icemelon404.community.commons.exception.ServerError;
import com.icemelon404.community.post.domain.upload.PostUploadService;
import com.icemelon404.community.post.domain.dto.ImageData;
import com.icemelon404.community.post.domain.dto.ImageType;
import com.icemelon404.community.post.domain.dto.PostUploadCommand;
import com.icemelon404.community.user.UserInfo;
import com.icemelon404.community.user.auth.RequireAuth;
import com.icemelon404.community.user.resolver.RequestUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UploadAPI {

    private final PostUploadService uploadService;

    @RequireAuth
    @PostMapping("/upload")
    public void uploadPost(@RequestUser UserInfo user,
                           @RequestParam("image") MultipartFile[] files,
                           @RequestParam("content") String content) {
        List<ImageData> imageDataList= Arrays.stream(files).map(this::imageDataOf).collect(Collectors.toList());
        PostUploadCommand command = PostUploadCommand
                .builder()
                .authorId(user.getId())
                .uploadImages(imageDataList)
                .content(content)
                .build();
        uploadService.uploadPost(command);
    }

    private ImageData imageDataOf(MultipartFile file) {
        return new ImageData(imageType(Objects.requireNonNull(file.getContentType())), file.getSize()) {
            @Override
            public InputStream imageInputStream() {
                try {
                    return file.getInputStream();
                } catch (IOException exception) {
                    throw new ServerError("이미지를 읽기 중 오류가 발생하였습니다");
                }
            }
        };
    }

    private ImageType imageType(String contentType) {
        if (contentType.equals("image/jpeg"))
            return ImageType.JPEG;
        else if (contentType.equals("image/png"))
            return ImageType.PNG;
        throw new IllegalArgumentException("contentType: " + contentType + " 은 이미지 포맷이 아닙니다");
    }
}
