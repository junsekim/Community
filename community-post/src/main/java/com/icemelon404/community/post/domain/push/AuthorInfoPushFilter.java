package com.icemelon404.community.post.domain.push;

import com.icemelon404.community.post.domain.dto.PostUploadCommand;
import com.icemelon404.community.post.domain.entity.Post;
import com.icemelon404.community.post.domain.upload.PostInfo;
import com.icemelon404.community.post.domain.upload.PostUploadFilter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthorInfoPushFilter implements PostUploadFilter {

    private final AuthorInfoPushHandler pusher;

    @Override
    public void preUpload(PostUploadCommand command) {
    }

    @Override
    public void postUpload(PostInfo uploadedPost) {
        if (uploadedPost.isNewPost())
            pusher.pushAuthorInfo(authorInfo(uploadedPost));
    }

    private AuthorInfo authorInfo(PostInfo post) {
        return new AuthorInfo(post.getAuthor(), post.getId());
    }
}
