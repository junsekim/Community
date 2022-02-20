package com.icemelon404.community.auth.api;

import com.icemelon404.community.auth.domain.login.LoginService;
import com.icemelon404.community.auth.domain.dto.LoginCommand;
import com.icemelon404.community.auth.domain.dto.LoginInfo;
import com.icemelon404.community.user.UserInfo;
import com.icemelon404.community.user.UserInfoInjector;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginApi {

    private final LoginService service;
    private final UserInfoInjector injector;

    @PostMapping("/login")
    public void login(@RequestBody LoginCommand command, HttpServletResponse response) {
        LoginInfo loginResult = service.tryLogin(command);
        injector.injectUserInfo(response, userInfo(loginResult));
    }

    private UserInfo userInfo(LoginInfo info) {
        return new UserInfo(info.getUserId(), info.getMailAddress(), info.getUserName());
    }
}
