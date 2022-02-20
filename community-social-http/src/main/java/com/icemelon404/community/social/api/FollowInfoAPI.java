package com.icemelon404.community.social.api;

import com.icemelon404.community.commons.dto.AscPagedRequest;
import com.icemelon404.community.social.domain.follow.info.FollowInfoFetchService;
import com.icemelon404.community.social.domain.dto.FollowInfo;
import com.icemelon404.community.user.UserInfo;
import com.icemelon404.community.user.UserToUserAuthorizer;
import com.icemelon404.community.user.auth.RequireAuth;
import com.icemelon404.community.user.resolver.RequestUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/social/info")
@RequiredArgsConstructor
public class FollowInfoAPI {

    private final FollowInfoFetchService service;
    private final UserToUserAuthorizer authorizer;

    @GetMapping("/followee/{followerId}")
    public ResponseEntity<List<FollowInfo>> getFolloweeInfo(@RequestUser UserInfo requester,
                                                            @RequestParam AscPagedRequest<Long> request,
                                                            @PathVariable("followerId") long followerId) {
        authorizer.checkAuthorized(requester, followerId);
        return ResponseEntity.ok(service.getFollows(followerId, request));
    }

    @RequireAuth
    @GetMapping("/followee")
    public ResponseEntity<List<FollowInfo>> getFollowerInfo(@RequestUser UserInfo userInfo,
                                                            @RequestParam AscPagedRequest<Long> request) {
        return ResponseEntity.ok(service.getFollows(userInfo.getId(), request));
    }

    @GetMapping("/follow/{followerId}")
    public ResponseEntity<List<FollowInfo>> getInfo(@RequestUser UserInfo requester,
                                                    @RequestParam AscPagedRequest<Long> request,
                                                    @PathVariable("followerId") long followeeId) {
        authorizer.checkAuthorized(requester, followeeId);
        return ResponseEntity.ok(service.getFollowers(followeeId, request));
    }

    @RequireAuth
    @GetMapping("/follower")
    public ResponseEntity<List<FollowInfo>> getInfo(@RequestUser UserInfo userInfo,
                                                    @RequestParam AscPagedRequest<Long> request) {
        return ResponseEntity.ok(service.getFollowers(userInfo.getId(), request));
    }
}
