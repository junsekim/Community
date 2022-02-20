package com.icemelon404.community.post.domain.push;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class AuthorInfoPushHandlerComposite implements AuthorInfoPushHandler {

    private final List<AuthorInfoPushHandler> handlers;

    @Override
    public void pushAuthorInfo(AuthorInfo info) {
        handlers.forEach(it -> it.pushAuthorInfo(info));
    }
}
