package com.icemelon404.community.social.api;

import com.icemelon404.community.social.domain.follow.count.FollowCountService;
import com.icemelon404.community.social.domain.dto.FollowCount;
import com.icemelon404.community.user.UserInfo;
import com.icemelon404.community.user.auth.RequireAuth;
import com.icemelon404.community.user.resolver.RequestUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/social")
public class CountAPI {

    private final FollowCountService service;

    @RequireAuth
    @GetMapping("/count")
    public ResponseEntity<FollowCount> getCount(@RequestUser UserInfo userInfo) {
        return ResponseEntity.ok(service.getCount(userInfo.getId()));
    }

    @GetMapping("/count/{userId}")
    public ResponseEntity<FollowCount> getCount(@PathVariable long userId) {
        return ResponseEntity.ok(service.getCount(userId));
    }
}
