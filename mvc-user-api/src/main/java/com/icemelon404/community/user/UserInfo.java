package com.icemelon404.community.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserInfo {
    private final long id;
    private final String mailAddress;
    private final String userName;
}
