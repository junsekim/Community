package com.icemelon404.community.social.domain.follow.paged;

import com.icemelon404.community.commons.dto.ConcretePagedRequest;
import com.icemelon404.community.social.domain.follow.entity.Follow;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class PagedFollowerFetchServiceImpl implements PagedFollowerFetchService{

    private final PagedFollowerReader reader;

    @Override
    public List<Long> getFollowers(long followeeId, ConcretePagedRequest request) {
        return reader.getFollowers(followeeId, request).stream()
                .map(Follow::getFollower)
                .collect(Collectors.toUnmodifiableList());
    }
}
