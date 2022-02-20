package com.icemelon404.community.auth.domain.login;

import com.icemelon404.community.auth.domain.entity.User;

import java.util.Optional;

public interface UserReader {
    Optional<User> findUserByUserName(String userName);
}
