package com.icemelon404.community.dispatcher.infra;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icemelon404.community.commons.exception.ServerError;
import com.icemelon404.community.dispatcher.domain.PagedAuthorInfo;
import com.icemelon404.community.dispatcher.domain.paging.PagedAuthorInfoPusher;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class KafkaPagedAuthorInfoPusher implements PagedAuthorInfoPusher {

    private final KafkaTemplate<Long, String> template;
    private final ObjectMapper mapper = new ObjectMapper();
    @Override
    public Mono<Void> pushPagedAuthorInfo(PagedAuthorInfo info) {
        return Mono.create(sink -> {
            try {
                template.sendDefault(info.postId(), mapper.writeValueAsString(info)).addCallback((result) -> sink.success(), sink::error);
            } catch (JsonProcessingException e) {
                sink.error(new ServerError("",e));
            }
        });

    }
}
