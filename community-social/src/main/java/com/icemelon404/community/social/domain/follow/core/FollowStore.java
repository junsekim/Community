package com.icemelon404.community.social.domain.follow.core;


import com.icemelon404.community.social.domain.follow.entity.Follow;

public interface FollowStore {
    void add(Follow follow);
    boolean has(Follow follow);
    void remove(Follow follow);
}
