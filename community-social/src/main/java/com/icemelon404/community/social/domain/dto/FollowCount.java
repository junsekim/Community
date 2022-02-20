package com.icemelon404.community.social.domain.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class FollowCount {
    private final int follower;
    private final int follow;
}
