package com.icemelon404.community.social.api;

import com.icemelon404.community.social.domain.request.FollowRequestService;
import com.icemelon404.community.social.domain.dto.FollowCommand;
import com.icemelon404.community.user.UserInfo;
import com.icemelon404.community.user.auth.RequireAuth;
import com.icemelon404.community.user.resolver.RequestUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/social")
@RequiredArgsConstructor
public class RequestAPI {

    private final FollowRequestService service;

    @RequireAuth
    @PostMapping(value="/request/{followId}")
    public ResponseEntity<Void> requestFollow(@RequestUser UserInfo user,
                                              @PathVariable("followId") long followId) {
        FollowCommand relation = new FollowCommand(user.getId(), followId);
        service.request(relation);
        return ResponseEntity.ok().build();
    }

    @RequireAuth
    @PostMapping(value= "/accept/{followerId}")
    public ResponseEntity<Void> acceptFollow(@RequestUser UserInfo accepter,
                                             @PathVariable("followerId") long followerId) {
        FollowCommand relation = new FollowCommand(followerId, accepter.getId());
        service.accept(relation);
        return ResponseEntity.ok().build();
    }


    @RequireAuth
    @PostMapping(value= "/refuse/{followerId}")
    public ResponseEntity<Void> refuseFollow(@RequestUser UserInfo accepter,
                                             @PathVariable("followerId") long followerId) {
        FollowCommand relation = new FollowCommand(followerId, accepter.getId());
        service.cancel(relation);
        return ResponseEntity.ok().build();
    }


    @RequireAuth
    @PostMapping(value= "/cancel/{followId}")
    public ResponseEntity<Void> cancelFollow(@RequestUser UserInfo requester,
                                             @PathVariable("followId") long followId) {
        FollowCommand relation = new FollowCommand(requester.getId(), followId);
        service.cancel(relation);
        return ResponseEntity.ok().build();
    }
}
