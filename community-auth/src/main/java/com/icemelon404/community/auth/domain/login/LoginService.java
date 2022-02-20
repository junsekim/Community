package com.icemelon404.community.auth.domain.login;

import com.icemelon404.community.auth.domain.dto.LoginCommand;
import com.icemelon404.community.auth.domain.dto.LoginInfo;

public interface LoginService {
    LoginInfo tryLogin(LoginCommand command);
}
