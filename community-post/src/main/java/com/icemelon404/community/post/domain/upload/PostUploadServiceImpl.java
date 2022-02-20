package com.icemelon404.community.post.domain.upload;

import com.icemelon404.community.post.domain.image.PostImageService;
import com.icemelon404.community.post.domain.dto.ImageData;
import com.icemelon404.community.post.domain.dto.PostUploadCommand;
import com.icemelon404.community.post.domain.entity.Post;
import com.icemelon404.community.post.domain.entity.PostImage;
import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

@RequiredArgsConstructor
public class PostUploadServiceImpl implements PostUploadService {

    private final PostStore repository;
    private final PostUploadFilter filter;
    private final PostImageService imageService;

    @Override
    public void uploadPost(PostUploadCommand uploadCommand) {
        doFilterAndSave(() -> newPostOf(uploadCommand), uploadCommand);
    }

    @Override
    public void updatePost(long postId, PostUploadCommand uploadCommand) {
        doFilterAndSave(() -> updatedPostOf(postId, uploadCommand), uploadCommand);
    }

    private void doFilterAndSave(Supplier<Post> postSupplier, PostUploadCommand uploadCommand) {
        filter.preUpload(uploadCommand);
        Post entity = repository.savePost(postSupplier.get());
        filter.postUpload(infoOf(entity));
    }

    private PostInfo infoOf(Post entity) {
        return new PostInfo(entity.getId(), entity.getId() != null, entity.getAuthorId(), entity.getContent());
    }

    private Post newPostOf(PostUploadCommand command) {
        return Post.builder()
                .authorId(command.getAuthorId())
                .content(command.getContent())
                .images(postImagesOf(command.getUploadImages()))
                .build();
    }

    public Post updatedPostOf(long postId, PostUploadCommand uploadCommand) {
        Post post = newPostOf(uploadCommand);
        post.setId(postId);
        return post;
    }

    private List<PostImage> postImagesOf(List<ImageData> imageData) {
        List<String> imageIds = imageService.uploadAndGetIds(imageData);
        List<PostImage> ret = new LinkedList<>();
        imageIds.stream().map(PostImage::new).forEach(ret::add);
        return ret;
    }

}
