package com.icemelon404.community.dispatcher.domain;

import com.icemelon404.community.commons.dto.ConcretePagedRequest;
import com.icemelon404.community.dispatcher.domain.paging.AuthorInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
public class PagedAuthorInfo {
    private final AuthorInfo authorInfo;
    private final ConcretePagedRequest request;


    public long authorId() {
        return this.getAuthorInfo().getAuthorId();
    }

    public long postId() {
        return this.getAuthorInfo().getPostId();
    }

    public int pageIndex() {
        return this.getRequest().getRequestPage();
    }

    public int totalPage() {
        return this.getRequest().getTotalPage();
    }
}
