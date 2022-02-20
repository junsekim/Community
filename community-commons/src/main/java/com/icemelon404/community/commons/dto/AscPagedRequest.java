package com.icemelon404.community.commons.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class AscPagedRequest<T> {
    private final T boundary;
    private final int size;
}
