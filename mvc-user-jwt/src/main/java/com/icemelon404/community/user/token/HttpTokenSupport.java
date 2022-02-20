package com.icemelon404.community.user.token;

import com.icemelon404.community.user.UserInfo;
import com.icemelon404.community.user.UserInfoExtractor;
import com.icemelon404.community.user.UserInfoInjector;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
public class HttpTokenSupport implements UserInfoInjector, UserInfoExtractor {

    private final TokenProvider provider;
    private final String HEADER_NAME;
    private final String TOKEN_TYPE;

    @Override
    public UserInfo extractUserInfo(HttpServletRequest request) {
        return provider.parseUserInfoFromToken(separateToken(request.getHeader(HEADER_NAME)));
    }

    private String separateToken(String header) {
        return header.split(" ")[1];
    }

    @Override
    public void injectUserInfo(HttpServletResponse response, UserInfo info) {
        response.setHeader(HEADER_NAME, prefixType(provider.createToken(info)));
    }

    private String prefixType(String token) {
        return TOKEN_TYPE + " " + token;
    }
}
