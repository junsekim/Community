package com.icemelon404.community.social.api;

import com.icemelon404.community.commons.dto.AscPagedRequest;
import com.icemelon404.community.social.domain.request.FollowRequestFetchService;
import com.icemelon404.community.social.domain.dto.FollowRequestInfo;
import com.icemelon404.community.user.UserInfo;
import com.icemelon404.community.user.auth.RequireAuth;
import com.icemelon404.community.user.resolver.RequestUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/social/info")
@RequiredArgsConstructor
public class RequestInfoAPI {

    private final FollowRequestFetchService service;

    @RequireAuth
    @GetMapping("/request/fan-out")
    public ResponseEntity<List<FollowRequestInfo>> getFanOutRequests(@RequestUser UserInfo user,
                                                                      @RequestParam AscPagedRequest<Long> request) {
        return ResponseEntity.ok(service.getFanOutRequest(user.getId(), request));
    }

    @RequireAuth
    @GetMapping("/request/fan-in")
    public ResponseEntity<List<FollowRequestInfo>> getFanInRequests(@RequestUser UserInfo user,
                                                                    @RequestParam AscPagedRequest<Long> request) {
        return ResponseEntity.ok(service.getFanInRequest(user.getId(), request));
    }

}
