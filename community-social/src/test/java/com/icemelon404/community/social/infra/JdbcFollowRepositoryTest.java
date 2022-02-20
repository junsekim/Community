package com.icemelon404.community.social.infra;

import com.icemelon404.community.commons.dto.AscPagedRequest;
import com.icemelon404.community.commons.dto.ConcretePagedRequest;
import com.icemelon404.community.social.domain.follow.entity.Follow;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@SpringBootTest(classes = JdbcTestConfig.class)
public class JdbcFollowRepositoryTest {

    @Autowired
    private JdbcFollowRepository repository;

    @Test
    @Transactional
    public void hasFollowTest() {
        long follower = 10;
        long followee = 11;
        repository.add(new Follow(follower, followee));
        Assertions.assertTrue(repository.has(new Follow(follower, followee)));
    }

    @Test
    @Transactional
    public void removeTest() {
        Follow follow = new Follow(10, 20);
        repository.add(follow);
        repository.remove(follow);
        Assertions.assertFalse(repository.has(follow));
    }

    @Test
    @Transactional
    public void followerFetchTest() {
        long followee = 1;
        List<Long> followers = List.of(2L,3L,4L,5L,6L,7L,8L,9L);
        followers.stream().map(it -> new Follow(it, followee)).forEach(it -> repository.add(it));
        List<Long> fetchedFollowers = repository.getFollowers(followee, new AscPagedRequest<>(0L, 3))
                .stream()
                .map(Follow::getFollower)
                .collect(Collectors.toUnmodifiableList());
        Assertions.assertEquals(List.of(2L, 3L, 4L), fetchedFollowers);
    }

    @Test
    @Transactional
    public void followeeFetchTest() {
        long follower = 1;
        List<Long> followees = List.of(2L,3L,4L,5L,6L,7L,8L,9L);
        followees.stream().map(it -> new Follow(follower, it)).forEach(it -> repository.add(it));
        List<Long> fetchedFollowers = repository.getFollows(follower, new AscPagedRequest<>(0L, 3))
                .stream()
                .map(Follow::getFollowee)
                .collect(Collectors.toUnmodifiableList());
        Assertions.assertEquals(List.of(2L, 3L, 4L), fetchedFollowers);
    }

    @Test
    @Transactional
    public void concretePagingTest() {
        long followee = 1;
        followers().stream().map(it -> new Follow(it, followee)).forEach(it -> repository.add(it));
        int pageSize = 5;
        List<Long> fetchedFollowers = new ArrayList<>();
        for (int i = 0; i < pageSize; i++) {
            fetchedFollowers.addAll(repository.getFollowers(followee, new ConcretePagedRequest(pageSize, i))
                    .stream()
                    .map(Follow::getFollower)
                    .collect(Collectors.toList()));
        }
        Collections.sort(fetchedFollowers);
        Assertions.assertEquals(followers(), fetchedFollowers);
    }

    private List<Long> followers() {
        return LongStream.range(4, 100).boxed().collect(Collectors.toUnmodifiableList());
    }

}
