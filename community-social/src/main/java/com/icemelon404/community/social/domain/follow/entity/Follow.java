package com.icemelon404.community.social.domain.follow.entity;

import lombok.Getter;
import java.time.LocalDateTime;


@Getter
public class Follow {

    private long follower;
    private long followee;
    private final LocalDateTime createdDate = LocalDateTime.now();

    public Follow(long follower, long followee) {
        this.followee = followee;
        this.follower = follower;
    }

}
