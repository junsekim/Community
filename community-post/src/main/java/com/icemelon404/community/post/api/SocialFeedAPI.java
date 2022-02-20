package com.icemelon404.community.post.api;

import com.icemelon404.community.commons.dto.PagedRequest;
import com.icemelon404.community.post.domain.feed.FeedDetailsService;
import com.icemelon404.community.post.domain.feed.FeedPreviewService;
import com.icemelon404.community.post.domain.dto.PostDetails;
import com.icemelon404.community.post.domain.dto.PostPreview;
import com.icemelon404.community.user.UserInfo;
import com.icemelon404.community.user.auth.RequireAuth;
import com.icemelon404.community.user.resolver.RequestUser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/feed/social")
public class SocialFeedAPI {

    private final FeedDetailsService feedService;
    private final FeedPreviewService previewService;

    public SocialFeedAPI(@Qualifier("social") FeedDetailsService service,
                         @Qualifier("social") FeedPreviewService previewService) {
        this.feedService = service;
        this.previewService = previewService;
    }

    @RequireAuth
    @GetMapping("/details")
    public ResponseEntity<List<PostDetails>> getFeed(@RequestUser UserInfo userInfo,
                                                     @RequestParam PagedRequest<Long> request) {
        return ResponseEntity.ok(feedService.requestFeed(userInfo.getId(), request));
    }

    @RequireAuth
    @GetMapping("/preview")
    public ResponseEntity<List<PostPreview>> getFeedPreview(@RequestUser UserInfo userInfo,
                                                            @RequestParam PagedRequest<Long> request) {
        return ResponseEntity.ok(previewService.requestPreview(userInfo.getId(), request));
    }
}
