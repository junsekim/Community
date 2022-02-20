package com.icemelon404.community.social.domain.follow.core;

import com.icemelon404.community.social.domain.dto.FollowCommand;
import com.icemelon404.community.social.domain.follow.entity.Follow;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class FollowServiceImpl implements FollowService {

    private final FollowStore store;
    private final FollowEventPushHandler handler;

    @Override
    public void addFollow(FollowCommand command) {
        Follow follow = followOf(command);
        store.add(follow);
        handler.onFollow(command);
        log.info("팔로우 추가 {} -> {}", follow.getFollower(), follow.getFollowee());
    }

    @Override
    public void removeFollow(FollowCommand command) {
        Follow follow = followOf(command);
        store.remove(follow);
        handler.onUnfollow(command);
        log.info("언팔로우 {} -> {}", follow.getFollower(), follow.getFollowee());
    }

    @Override
    public boolean hasFollow(FollowCommand command) {
        return store.has(followOf(command));
    }

    private Follow followOf(FollowCommand command) {
        return new Follow(command.getFollower(), command.getFollowee());
    }

}
