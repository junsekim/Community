package com.icemelon404.community.auth.domain.login;

import com.icemelon404.community.auth.domain.encoder.PasswordEncoder;
import com.icemelon404.community.auth.domain.dto.LoginCommand;
import com.icemelon404.community.auth.domain.dto.LoginInfo;
import com.icemelon404.community.auth.domain.entity.User;
import com.icemelon404.community.commons.exception.ForbiddenActionException;
import com.icemelon404.community.commons.exception.NoSuchResourceException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final UserReader reader;
    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginInfo tryLogin(LoginCommand command) {
        User matchedUser = reader.findUserByUserName(command.getUserName())
                .orElseThrow(()-> new NoSuchResourceException("존재하지 않는 아이디입니다."));
        boolean passwordMatches = passwordEncoder.matches(matchedUser.getPassword(), command.getPassword());
        if (!passwordMatches)
            throw new ForbiddenActionException("패스워드가 일치하지 않습니다.");
        return loginInfo(matchedUser);
    }

    private LoginInfo loginInfo(User user) {
        return new LoginInfo(user.getId(), user.getUserName(), user.getMailAddress());
    }
}
