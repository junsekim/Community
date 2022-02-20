package com.icemelon404.community.post.domain.upload;

import com.icemelon404.community.post.domain.dto.PostUploadCommand;
import com.icemelon404.community.post.domain.entity.Post;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PostUploadFilterChain implements PostUploadFilter {

    private final List<PostUploadFilter> filters;

    @Override
    public void preUpload(PostUploadCommand command) {
        filters.forEach((it) -> it.preUpload(command));
    }

    @Override
    public void postUpload(PostInfo uploadedPost) {
        filters.forEach((it) -> it.postUpload(uploadedPost));
    }
}
