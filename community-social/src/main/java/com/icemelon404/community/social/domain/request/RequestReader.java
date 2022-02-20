package com.icemelon404.community.social.domain.request;

import com.icemelon404.community.commons.dto.AscPagedRequest;

import java.util.List;

public interface RequestReader {
    List<FollowRequest> getFanInRequests(long destId, AscPagedRequest<Long> request);
    List<FollowRequest> getFanOutRequests(long srcId, AscPagedRequest<Long> request);
}
