package com.icemelon404.community.user;

public interface UserToUserAuthorizer {
    void checkAuthorized(UserInfo requester, long targetUserId);
}
