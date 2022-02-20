package com.icemelon404.community.dispatcher.domain.paging;

import com.icemelon404.community.dispatcher.domain.PagedAuthorInfo;
import reactor.core.publisher.Mono;

public interface PagedAuthorInfoPusher {
    Mono<Void> pushPagedAuthorInfo(PagedAuthorInfo info);
}
