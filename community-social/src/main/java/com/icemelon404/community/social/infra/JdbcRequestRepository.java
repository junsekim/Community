package com.icemelon404.community.social.infra;

import com.icemelon404.community.commons.dto.AscPagedRequest;
import com.icemelon404.community.commons.exception.DuplicateResourceException;
import com.icemelon404.community.commons.exception.NoSuchResourceException;
import com.icemelon404.community.social.domain.request.FollowRequest;
import com.icemelon404.community.social.domain.request.RequestReader;
import com.icemelon404.community.social.domain.request.RequestStore;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@RequiredArgsConstructor
public class JdbcRequestRepository implements RequestStore, RequestReader {

    private final JdbcTemplate template;

    @Override
    public List<FollowRequest> getFanInRequests(long destId, AscPagedRequest<Long> request) {
        return template.query("SELECT * FROM request WHERE receiver_id= ? AND sender_id > ? LIMIT ?",
                (rs, rowNum) -> new FollowRequest(rs.getLong("sender_id"),rs.getLong("receiver_id")),
                destId, request.getBoundary(), request.getSize());
    }

    @Override
    public List<FollowRequest> getFanOutRequests(long srcId, AscPagedRequest<Long> request) {
        return template.query("SELECT * FROM request WHERE sender_id= ? AND receiver_id > ? LIMIT ?",
                (rs, rowNum) -> new FollowRequest(rs.getLong("sender_id"),rs.getLong("receiver_id")),
                srcId, request.getBoundary(), request.getSize());
    }

    @Override
    public void save(FollowRequest relation) {
        try {
            template.update("INSERT INTO request (sender_id, receiver_id) VALUES(?, ?)", relation.getSender(), relation.getReceiver());
        } catch (DuplicateKeyException e) {
            throw new DuplicateResourceException(relation.getSender() + " -> " + relation.getReceiver() + " 요청이 이미 존재합니다");
        }
    }

    @Override
    public boolean has(FollowRequest relation) {
        return template.queryForObject("SELECT COUNT(*) FROM request WHERE sender_id= ? AND receiver_id= ?", Integer.class,
                relation.getSender(), relation.getReceiver()) > 0;

    }

    @Override
    public void remove(FollowRequest relation) {
        int removeSuccess = template.update("DELETE FROM request WHERE sender_id= ? AND receiver_id= ?",
                relation.getSender(), relation.getReceiver());
        if (removeSuccess == 0)
            throw new NoSuchResourceException(relation.getSender() + "->" + relation.getReceiver() + " 존재하지 않는 요청입니다");
    }
}
