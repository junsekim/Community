package com.icemelon404.community.social.infra;

import com.icemelon404.community.commons.dto.AscPagedRequest;
import com.icemelon404.community.commons.dto.ConcretePagedRequest;
import com.icemelon404.community.commons.exception.DuplicateResourceException;
import com.icemelon404.community.commons.exception.NoSuchResourceException;
import com.icemelon404.community.social.domain.follow.entity.Follow;
import com.icemelon404.community.social.domain.follow.core.FollowStore;
import com.icemelon404.community.social.domain.follow.info.FollowReader;
import com.icemelon404.community.social.domain.follow.paged.PagedFollowerReader;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
public class JdbcFollowRepository implements FollowReader, FollowStore, PagedFollowerReader {

    private final JdbcTemplate template;
    private final int RANDOM_BOUND = 100;
    private final Pager pager = new Pager();

    @Override
    public void add(Follow follow) {
        try {
            template.update("INSERT INTO follow (follower, followee, random) VALUES (?,?, ?)",
                    follow.getFollower(), follow.getFollowee(), ThreadLocalRandom.current().nextInt(RANDOM_BOUND));
        } catch (DuplicateKeyException e) {
            throw new DuplicateResourceException(follow.getFollower() + "->" + follow.getFollowee() + " 는 팔로우 상태입니다");
        }
    }

    @Override
    public boolean has(Follow follow) {
        return template.queryForObject("SELECT COUNT(*) FROM follow WHERE follower= ?", Integer.class, follow.getFollower()) > 0;
    }

    @Override
    public void remove(Follow follow) {
        int removeSuccess = template.update("DELETE FROM follow WHERE follower= ? AND followee= ?", follow.getFollower(), follow.getFollowee());
        if (removeSuccess == 0)
            throw new NoSuchResourceException(follow.getFollower() + " -> " + follow.getFollowee() + " 팔로우 관계가 존재하지 않습니다");
    }

    @Override
    public List<Follow> getFollowers(long followee, AscPagedRequest<Long> request) {
        return template.query("SELECT * FROM follow WHERE followee= ? AND follower > ? LIMIT ?",
                (row, rowNum) -> new Follow(row.getLong("follower"), row.getLong("followee")),
                followee, request.getBoundary(), request.getSize());
    }

    @Override
    public List<Follow> getFollows(long follower, AscPagedRequest<Long> request) {
        return template.query("SELECT * FROM follow WHERE follower= ? AND followee > ? LIMIT ?",
                (row, rowNum) -> new Follow(row.getLong("follower"), row.getLong("followee")),
                follower, request.getBoundary(), request.getSize());
    }

    @Override
    public List<Follow> getFollowers(long followee, ConcretePagedRequest request) {
        Boundary boundary = pager.getPage(request, RANDOM_BOUND);
        return template.query("SELECT * FROM follow WHERE followee= ? AND random >= ? AND random < ?",
                (row, rowNum) -> new Follow(row.getLong("follower"), row.getLong("followee")),
                followee, boundary.getLow(), boundary.getHigh());
    }
}
