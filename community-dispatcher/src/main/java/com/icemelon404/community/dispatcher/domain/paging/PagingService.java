package com.icemelon404.community.dispatcher.domain.paging;

import com.icemelon404.community.commons.dto.ConcretePagedRequest;
import com.icemelon404.community.dispatcher.domain.PagedAuthorInfo;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class PagingService {

    private final FollowerCountFetcher fetcher;
    private final PagedAuthorInfoPusher pusher;
    private final int pageSize;

    public Mono<Void> paginateAuthorInfo(AuthorInfo info) {
        Mono<Integer> followerCnt = fetcher.fetchFollowerCount(info.getAuthorId());
        return followerCnt
                .map(this::pageCnt)
                .flatMapMany(pageCnt -> pagedAuthorInfo(info, pageCnt))
                .flatMap(pusher::pushPagedAuthorInfo)
                .then();
    }

    private Flux<PagedAuthorInfo> pagedAuthorInfo(AuthorInfo info, int pageCnt) {
        return Flux
                .range(0, pageCnt)
                .map(idx -> new PagedAuthorInfo(info, new ConcretePagedRequest(pageCnt, idx)));
    }

    private int pageCnt(int followerCnt) {
        int div = followerCnt / pageSize;
        if (followerCnt % pageSize != 0)
            div++;
        return div;
    }
}
