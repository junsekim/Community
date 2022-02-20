package com.icemelon404.community.auth.domain.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LoginInfo {
    private final long userId;
    private final String userName;
    private final String mailAddress;
}
