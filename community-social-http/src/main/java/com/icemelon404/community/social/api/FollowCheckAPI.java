package com.icemelon404.community.social.api;

import com.icemelon404.community.social.domain.follow.core.FollowService;
import com.icemelon404.community.social.domain.dto.FollowCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/social")
@RequiredArgsConstructor
public class FollowCheckAPI {

    private final FollowService followService;

    @GetMapping("/check/{followerId}/{followeeId}")
    public ResponseEntity<Void> checkFollow(@PathVariable("followerId") long followerId,
                                            @PathVariable("followeeId") long followeeId) {
        if (followService.hasFollow(new FollowCommand(followerId, followeeId)))
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.notFound().build();
    }
}
