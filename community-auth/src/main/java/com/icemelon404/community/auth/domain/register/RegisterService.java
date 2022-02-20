package com.icemelon404.community.auth.domain.register;

import com.icemelon404.community.auth.domain.dto.RegisterCommand;

public interface RegisterService {
    void registerUser(RegisterCommand command);
}
