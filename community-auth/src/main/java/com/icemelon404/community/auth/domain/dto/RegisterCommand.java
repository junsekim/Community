package com.icemelon404.community.auth.domain.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class RegisterCommand {
    private final String userName;
    private final String password;
    private final String mailAddress;
}
