package com.icemelon404.community.auth.domain.register;

import com.icemelon404.community.auth.domain.encoder.PasswordEncoder;
import com.icemelon404.community.auth.domain.dto.RegisterCommand;
import com.icemelon404.community.auth.domain.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class RegisterServiceImpl implements RegisterService {

    private final UserStore userStore;
    private final RegisterEventPushHandler pushHandler;
    private final PasswordEncoder encoder;

    @Override
    public void registerUser(RegisterCommand command) {
        User registeredUser = userStore.save(userOf(command));
        pushHandler.onRegister(command);
        log.info("유저 회원가입 id= {}, name= {}", registeredUser.getId(), registeredUser.getUserName());
    }


    private User userOf(RegisterCommand command) {
        return User.builder()
                .userName(command.getUserName())
                .mailAddress(command.getMailAddress())
                .password(encoder.encode(command.getPassword()))
                .build();
    }
}
