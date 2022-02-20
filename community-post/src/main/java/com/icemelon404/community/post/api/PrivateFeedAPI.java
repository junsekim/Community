package com.icemelon404.community.post.api;

import com.icemelon404.community.commons.dto.PagedRequest;
import com.icemelon404.community.post.domain.feed.FeedDetailsService;
import com.icemelon404.community.post.domain.feed.FeedPreviewService;
import com.icemelon404.community.post.domain.dto.PostDetails;
import com.icemelon404.community.post.domain.dto.PostPreview;
import com.icemelon404.community.user.UserInfo;
import com.icemelon404.community.user.UserToUserAuthorizer;
import com.icemelon404.community.user.auth.RequireAuth;
import com.icemelon404.community.user.resolver.RequestUser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feed/private")
public class PrivateFeedAPI {

    private final FeedPreviewService preViewService;
    private final FeedDetailsService detailsService;
    private final UserToUserAuthorizer authorizer;

    public PrivateFeedAPI(@Qualifier("social") FeedDetailsService service,
                         @Qualifier("social") FeedPreviewService previewService,
                          UserToUserAuthorizer authorizer) {
        this.detailsService= service;
        this.preViewService = previewService;
        this.authorizer = authorizer;
    }

    @RequireAuth
    @GetMapping("/details")
    public ResponseEntity<List<PostDetails>> getFeed(@RequestUser UserInfo userInfo,
                                                     @RequestParam PagedRequest<Long> request) {
        return ResponseEntity.ok(detailsService.requestFeed(userInfo.getId(), request));
    }

    @RequireAuth
    @GetMapping("/preview")
    public ResponseEntity<List<PostPreview>> getFeedPreview(@RequestUser UserInfo userInfo,
                                                            @RequestParam PagedRequest<Long> request) {
        return ResponseEntity.ok(preViewService.requestPreview(userInfo.getId(), request));
    }

    @RequireAuth
    @GetMapping("/preview/{userId}")
    public ResponseEntity<List<PostPreview>> getFeedPreview(@RequestUser UserInfo requester,
                                                            @PathVariable("userId") long requestedUser,
                                                            @RequestParam PagedRequest<Long> request) {
        authorizer.checkAuthorized(requester, requestedUser);
        return ResponseEntity.ok(preViewService.requestPreview(requestedUser, request));
    }

    @RequireAuth
    @GetMapping("/details/{userId}")
    public ResponseEntity<List<PostDetails>> getFeed(@RequestUser UserInfo requester,
                                                     @PathVariable("userId") long requestedUser,
                                                     @RequestParam PagedRequest<Long> request) {
        authorizer.checkAuthorized(requester, requestedUser);
        return ResponseEntity.ok(detailsService.requestFeed(requestedUser, request));
    }
}
