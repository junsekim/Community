package com.icemelon404.community.auth.domain.encoder;

import org.mindrot.jbcrypt.BCrypt;

public class BcryptPasswordEncoder implements PasswordEncoder {
    @Override
    public boolean matches(String encoded, String rawPassword) {
        return BCrypt.checkpw(rawPassword, encoded);
    }

    @Override
    public String encode(String rawPassword) {
        return BCrypt.hashpw(rawPassword, BCrypt.gensalt());
    }
}
