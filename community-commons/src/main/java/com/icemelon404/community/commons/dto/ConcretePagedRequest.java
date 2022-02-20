package com.icemelon404.community.commons.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ConcretePagedRequest {
    private final int totalPage;
    private final int requestPage;
}
