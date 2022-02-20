package com.icemelon404.community.post.domain.upload;

import com.icemelon404.community.post.domain.dto.PostUploadCommand;
import com.icemelon404.community.post.domain.entity.Post;

public interface PostUploadFilter {
    void preUpload(PostUploadCommand command);

    void postUpload(PostInfo info);
}
