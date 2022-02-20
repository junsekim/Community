package com.icemelon404.community.commons.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PagedRequest<T> {
    private final T boundary;
    private final Direction requestDir;
    private final int size;
}
