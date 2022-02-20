package com.icemelon404.community.feed.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserWithPost {
    private final long ownerId;
    private final long postId;
}
