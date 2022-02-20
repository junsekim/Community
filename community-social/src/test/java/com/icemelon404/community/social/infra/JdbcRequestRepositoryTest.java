package com.icemelon404.community.social.infra;

import com.icemelon404.community.commons.dto.AscPagedRequest;
import com.icemelon404.community.social.domain.request.FollowRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest(classes= JdbcTestConfig.class)
public class JdbcRequestRepositoryTest {

    @Autowired
    private JdbcRequestRepository repository;

    @Test
    @Transactional
    public void hasRequestTest() {
        FollowRequest request = new FollowRequest(1, 2);
        repository.save(request);
        Assertions.assertTrue(repository.has(request));
    }

    @Test
    @Transactional
    public void removeTest() {
        FollowRequest request = new FollowRequest(1, 2);
        repository.save(request);
        repository.remove(request);
        Assertions.assertFalse(repository.has(request));
    }

    @Test
    @Transactional
    public void fanoutRequestFetchTest() {
        long sender = 1;
        List<Long> receivers = List.of(2L, 3L, 4L ,5L, 6L, 7L);
        receivers.stream()
                .map(it -> new FollowRequest(sender, it))
                .forEach(repository::save);
        List<Long> fanoutRequests = repository.getFanOutRequests(sender, new AscPagedRequest<>(0L, 6)).stream()
                .map(FollowRequest::getReceiver)
                .collect(Collectors.toList());
        Assertions.assertEquals(receivers, fanoutRequests);
    }
}
