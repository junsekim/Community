package com.icemelon404.community.auth.domain.register;

import com.icemelon404.community.auth.domain.entity.User;

public interface UserStore {
    User save(User user);
}
