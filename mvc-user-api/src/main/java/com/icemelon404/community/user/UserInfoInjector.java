package com.icemelon404.community.user;

import javax.servlet.http.HttpServletResponse;

public interface UserInfoInjector {
    void injectUserInfo(HttpServletResponse response, UserInfo info);
}
