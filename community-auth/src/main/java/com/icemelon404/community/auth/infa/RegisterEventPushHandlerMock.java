package com.icemelon404.community.auth.infa;

import com.icemelon404.community.auth.domain.dto.RegisterCommand;
import com.icemelon404.community.auth.domain.register.RegisterEventPushHandler;

public class RegisterEventPushHandlerMock implements RegisterEventPushHandler {

    @Override
    public void onRegister(RegisterCommand command) {

    }
}
