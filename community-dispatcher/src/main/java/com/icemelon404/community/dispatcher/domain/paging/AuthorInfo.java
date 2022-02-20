package com.icemelon404.community.dispatcher.domain.paging;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class AuthorInfo {
    private final long authorId;
    private final long postId;
}
