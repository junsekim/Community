package com.icemelon404.community.post.infra.feed;

import com.icemelon404.community.post.domain.push.AuthorInfo;
import com.icemelon404.community.post.infra.feed.grpc.GrpcPrivateFeedRepository;
import com.icemelon404.community.post.infra.feed.kafka.KafkaAuthorInfoPushHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GrpcPrivateFeedRepositoryTest {

    @Autowired
    private KafkaAuthorInfoPushHandler handler;

    @Test
    public void sendPushRequest() {

        handler.pushAuthorInfo(new AuthorInfo(0L ,4L));
    }
}
