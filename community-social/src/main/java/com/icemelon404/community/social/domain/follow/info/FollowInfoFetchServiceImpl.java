package com.icemelon404.community.social.domain.follow.info;

import com.icemelon404.community.commons.dto.AscPagedRequest;
import com.icemelon404.community.social.domain.dto.FollowInfo;
import com.icemelon404.community.social.domain.follow.entity.Follow;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class FollowInfoFetchServiceImpl implements FollowInfoFetchService {

    private final FollowReader reader;

    @Override
    public List<FollowInfo> getFollowers(long followee, AscPagedRequest<Long> request) {
        return reader.getFollowers(followee, request)
                .stream()
                .map(this::followInfo)
                .collect(Collectors.toList());
    }

    @Override
    public List<FollowInfo> getFollows(long follower, AscPagedRequest<Long> request) {
        return reader.getFollows(follower, request)
                .stream()
                .map(this::followInfo)
                .collect(Collectors.toList());
    }

    private FollowInfo followInfo(Follow follow) {
        return new FollowInfo(follow.getFollower(), follow.getFollowee());
    }
}
