package com.icemelon404.community.post.config;

import com.icemelon404.community.post.domain.feed.FeedDetailsService;
import com.icemelon404.community.post.domain.feed.FeedPreviewService;
import com.icemelon404.community.post.domain.image.PostImageService;
import com.icemelon404.community.post.domain.upload.PostUploadService;
import com.icemelon404.community.post.domain.feed.*;
import com.icemelon404.community.post.domain.push.AuthorInfoPushFilter;
import com.icemelon404.community.post.domain.push.AuthorInfoPushHandler;
import com.icemelon404.community.post.domain.upload.PostStore;
import com.icemelon404.community.post.domain.upload.PostUploadFilter;
import com.icemelon404.community.post.domain.upload.PostUploadServiceImpl;
import com.icemelon404.community.post.domain.view.PostDetailFetchServiceImpl;
import com.icemelon404.community.post.domain.view.PostPreviewFetchServiceImpl;
import com.icemelon404.community.post.domain.view.PostReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    @Qualifier("private")
    public FeedDetailsService privateDetailsService(PostDetailFetchService service, @Qualifier("private") FeedPostIdFetcher fetcher) {
        return new FeedDetailsServiceImpl(fetcher, service);
    }

    @Bean
    @Qualifier("private")
    public FeedPreviewService privatePreviewService(PostPreviewFetchService service, @Qualifier("private") FeedPostIdFetcher fetcher) {
        return new FeedPreviewServiceImpl(fetcher, service);
    }

    @Bean
    @Qualifier("social")
    public FeedDetailsService socialDetailsService(PostDetailFetchService service, @Qualifier("social") FeedPostIdFetcher fetcher) {
        return new FeedDetailsServiceImpl(fetcher, service);
    }

    @Bean
    @Qualifier("social")
    public FeedPreviewService socialPreviewService(PostPreviewFetchService service, @Qualifier("social") FeedPostIdFetcher fetcher) {
        return new FeedPreviewServiceImpl(fetcher, service);
    }

    @Bean
    public PostDetailFetchService detailFetchService(PostReader reader) {
        return new PostDetailFetchServiceImpl(reader);
    }

    @Bean
    public PostPreviewFetchServiceImpl postPreviewFetchService(PostReader reader) {
        return new PostPreviewFetchServiceImpl(reader);
    }

    @Bean
    public PostUploadService uploadService(PostStore store, PostUploadFilter filter, PostImageService imageService) {
        return new PostUploadServiceImpl(store, filter, imageService);
    }

    @Bean
    public PostUploadFilter pushFilter(@Qualifier("composite") AuthorInfoPushHandler handler) {
        return new AuthorInfoPushFilter(handler);
    }
}
