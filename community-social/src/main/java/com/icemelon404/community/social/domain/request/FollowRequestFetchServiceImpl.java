package com.icemelon404.community.social.domain.request;

import com.icemelon404.community.commons.dto.AscPagedRequest;
import com.icemelon404.community.social.domain.dto.FollowRequestInfo;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class FollowRequestFetchServiceImpl implements FollowRequestFetchService {

    private final RequestReader reader;

    @Override
    public List<FollowRequestInfo> getFanOutRequest(long srcId, AscPagedRequest<Long> request) {
        return reader.getFanOutRequests(srcId, request)
                .stream()
                .map(this::requestInfo)
                .collect(Collectors.toList());
    }

    @Override
    public List<FollowRequestInfo> getFanInRequest(long destId, AscPagedRequest<Long> request) {
        return reader.getFanInRequests(destId, request)
                .stream()
                .map(this::requestInfo)
                .collect(Collectors.toList());
    }

    private FollowRequestInfo requestInfo(FollowRequest request) {
        return new FollowRequestInfo(request.getSender(), request.getReceiver());
    }
}
