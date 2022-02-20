package com.icemelon404.community.social.domain.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class FollowCommand {
    private final long follower;
    private final long followee;
}
