package com.icemelon404.community.social.domain.follow.count;

import com.icemelon404.community.social.domain.dto.FollowCount;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FollowCountServiceImpl implements FollowCountService {

    private final FollowCountReader followCountStore;

    @Override
    public FollowCount getCount(long owner) {
        return followCountStore.getFollowCount(owner);
    }
}
