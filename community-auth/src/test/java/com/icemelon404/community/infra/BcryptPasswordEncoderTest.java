package com.icemelon404.community.infra;

import com.icemelon404.community.auth.domain.encoder.BcryptPasswordEncoder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class BcryptPasswordEncoderTest {

    private final BcryptPasswordEncoder encoder = new BcryptPasswordEncoder();

    @Test
    public void encodeAndMatch() {
        Assertions.assertTrue(randomPasswords(100).stream().allMatch(this::encodeAndMatch));
    }

    @Test
    public void matchWithRaw() {
        Assertions.assertFalse(randomPasswords(100).stream().anyMatch(password->tryMatch(password, password)));
    }

    private boolean encodeAndMatch(String password) {
        return encoder.matches(encoder.encode(password), password);
    }

    private boolean tryMatch(String encoded, String password) {
        try {
            return encoder.matches(encoded, password);
        } catch (Exception e) {
            return false;
        }
    }

    private List<String> randomPasswords(int size) {
        List<String> ret = new LinkedList<>();
        for (int i = 0; i < size; i++)
            ret.add(UUID.randomUUID().toString());
        return ret;
    }
}
