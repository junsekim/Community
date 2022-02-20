package com.icemelon404.community.social.domain.request;

import com.icemelon404.community.commons.dto.AscPagedRequest;
import com.icemelon404.community.social.domain.dto.FollowRequestInfo;

import java.util.List;

public interface FollowRequestFetchService {
    List<FollowRequestInfo> getFanOutRequest(long srcId, AscPagedRequest<Long> request);
    List<FollowRequestInfo> getFanInRequest(long destId, AscPagedRequest<Long> request);
}
