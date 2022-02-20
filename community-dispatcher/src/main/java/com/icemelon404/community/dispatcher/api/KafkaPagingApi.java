package com.icemelon404.community.dispatcher.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icemelon404.community.commons.exception.ServerError;
import com.icemelon404.community.dispatcher.domain.paging.AuthorInfo;
import com.icemelon404.community.dispatcher.domain.paging.PagingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;

import java.util.function.Consumer;

@RequiredArgsConstructor
@Slf4j
public class KafkaPagingApi implements AcknowledgingMessageListener<Long, String> {

    private final PagingService service;
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void onMessage(ConsumerRecord<Long, String> record, Acknowledgment ack) {
        try {
            AuthorInfo info = mapper.readValue(record.value(), AuthorInfo.class);
            service.paginateAuthorInfo(info).subscribe(null,
                    onError(ack, info), onComplete(ack, info));
        } catch (Exception e) {
            log.error("error: ", e);
            throw new ServerError("", e);
        }

    }

    private Consumer<? super Throwable> onError(Acknowledgment ack, AuthorInfo data) {
        return err -> {
            log.error("AuthorInfo 페이징 중 에러; 유저 아이디: {}, 포스트 아이디: {}, {}",
                    data.getAuthorId(), data.getPostId(), err);
            ack.acknowledge();
        };
    }

    private Runnable onComplete(Acknowledgment ack, AuthorInfo data) {
        return ()-> {
            log.debug("AuthorInfo 페이징 성공; 유저 아이디: {}, 포스트 아이디: {}",
                    data.getAuthorId(), data.getPostId());
            ack.acknowledge();
        };
    }
}
