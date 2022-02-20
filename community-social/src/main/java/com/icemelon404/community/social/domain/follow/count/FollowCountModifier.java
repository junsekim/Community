package com.icemelon404.community.social.domain.follow.count;

public interface FollowCountModifier {
    void modifyFollowCount(long userId, int amount);
    void modifyFollowerCount(long userId, int amount);
}
