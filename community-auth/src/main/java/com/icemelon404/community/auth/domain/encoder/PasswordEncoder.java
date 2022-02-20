package com.icemelon404.community.auth.domain.encoder;

public interface PasswordEncoder {
    boolean matches(String encoded, String rawPassword);
    String encode(String rawPassword);
}
