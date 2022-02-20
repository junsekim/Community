package com.icemelon404.community.social.domain.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class FollowRequestInfo {
    private final long requester;
    private final long accepter;
}
