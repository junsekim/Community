package com.icemelon404.community.post.domain.upload;

import com.icemelon404.community.post.domain.dto.PostUploadCommand;

public interface PostUploadService {
    void uploadPost(PostUploadCommand uploadCommand);
    void updatePost(long postId, PostUploadCommand uploadCommand);
}
