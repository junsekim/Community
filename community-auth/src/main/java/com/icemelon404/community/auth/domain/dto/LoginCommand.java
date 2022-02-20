package com.icemelon404.community.auth.domain.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LoginCommand {
    private final String userName;
    private final String password;
}
