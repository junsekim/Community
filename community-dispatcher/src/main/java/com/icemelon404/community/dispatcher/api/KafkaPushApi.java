package com.icemelon404.community.dispatcher.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icemelon404.community.commons.dto.ConcretePagedRequest;
import com.icemelon404.community.dispatcher.domain.PagedAuthorInfo;
import com.icemelon404.community.dispatcher.domain.paging.AuthorInfo;
import com.icemelon404.community.dispatcher.domain.push.PushService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;

import java.util.function.Consumer;

@RequiredArgsConstructor
@Slf4j
public class KafkaPushApi implements AcknowledgingMessageListener<Long, String> {

    private final PushService pushService;
    private final ObjectMapper mapper = new ObjectMapper();
    @Override
    public void onMessage(ConsumerRecord<Long, String> record, Acknowledgment ack) {
        try {
            PagedAuthorInfo data = mapper.readValue(record.value(), PagedAuthorInfo.class);
            pushService.dispatchPostIdToFollowers(data).subscribe((unused) -> {
                log.error("why here?");
                    },
                    onError(ack, data),
                    onComplete(ack, data));
        } catch (Exception e) {
            log.error("error: ", e);
            ack.acknowledge();
        }
    }


    private Consumer<? super Throwable> onError(Acknowledgment ack, PagedAuthorInfo data) {
        return ex -> {
            ack.acknowledge();
            log.error("피드 푸쉬 실패; 작성자 아이디: {}, 게시글 아이디: {}, 페이지: {} / {} ",
                    data.authorId(), data.postId(), data.pageIndex(), data.totalPage());
        };
    }

    private Runnable onComplete(Acknowledgment ack, PagedAuthorInfo data) {
        return  ()-> {
            ack.acknowledge();
            log.debug("피드 푸쉬 성공; 작성자 아이디: {}, 게시글 아이디: {}, 페이지: {} / {} ",
                    data.authorId(), data.postId(), data.pageIndex(), data.totalPage());
        };
    }

}
