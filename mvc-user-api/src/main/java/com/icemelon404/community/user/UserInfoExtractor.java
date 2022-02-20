package com.icemelon404.community.user;

import javax.servlet.http.HttpServletRequest;

public interface UserInfoExtractor {
    UserInfo extractUserInfo(HttpServletRequest request);
}
