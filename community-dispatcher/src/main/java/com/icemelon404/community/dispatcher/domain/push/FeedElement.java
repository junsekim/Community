package com.icemelon404.community.dispatcher.domain.push;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class FeedElement {
    private final long feedOwnerId;
    private final long postId;
}
