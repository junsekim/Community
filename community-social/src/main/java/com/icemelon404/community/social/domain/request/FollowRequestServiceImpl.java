package com.icemelon404.community.social.domain.request;

import com.icemelon404.community.social.domain.follow.core.FollowService;
import com.icemelon404.community.social.domain.dto.FollowCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class FollowRequestServiceImpl implements FollowRequestService {

    private final RequestStore requestRepository;
    private final FollowService followService;

    @Override
    public void request(FollowCommand relation) {
        requestRepository.save(followRequest(relation));
        log.info("팔로우 요청: {} -> {}", relation.getFollower(), relation.getFollowee());
    }

    @Override
    public void accept(FollowCommand relation) {
        FollowRequest request = followRequest(relation);
        requestRepository.remove(request);
        followService.addFollow(followCommand(request));
    }

    @Override
    public void cancel(FollowCommand relation) {
        FollowRequest request = followRequest(relation);
        requestRepository.remove(request);
        log.info("팔로우 요청 취소 {} -> {}", relation.getFollower(), relation.getFollowee());
    }

    private FollowRequest followRequest(FollowCommand relation) {
        return new FollowRequest(relation.getFollower(), relation.getFollowee());
    }

    private FollowCommand followCommand(FollowRequest info) {
        return new FollowCommand(info.getSender(), info.getReceiver());
    }
}
