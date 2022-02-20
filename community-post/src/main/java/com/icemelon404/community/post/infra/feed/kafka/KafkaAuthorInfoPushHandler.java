package com.icemelon404.community.post.infra.feed.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icemelon404.community.commons.exception.ServerError;
import com.icemelon404.community.post.domain.push.AuthorInfo;
import com.icemelon404.community.post.domain.push.AuthorInfoPushHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;

@RequiredArgsConstructor
@Slf4j
public class KafkaAuthorInfoPushHandler implements AuthorInfoPushHandler {

    private final KafkaTemplate<Long, String> template;
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void pushAuthorInfo(AuthorInfo info) {
        try {
            template.sendDefault(info.getPostId(), mapper.writeValueAsString(info)).addCallback(new ListenableFutureCallback<>() {
                @Override
                public void onFailure(Throwable ex) {
                    log.error("AuthorInfo 전달 실패: {}, {}", info, ex.getMessage());
                }

                @Override
                public void onSuccess(SendResult<Long, String> result) {
                    log.debug("AuthorInfo 전달 성공: {}", info);
                }
            });
        } catch (Exception e) {
            throw new ServerError("", e);
        }
    }
}
