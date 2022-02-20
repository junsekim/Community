package com.icemelon404.community.user.token;

import com.icemelon404.community.user.UserInfo;

public interface TokenProvider {
    public String createToken(UserInfo token);
    public UserInfo parseUserInfoFromToken(String tokenStr);
}
