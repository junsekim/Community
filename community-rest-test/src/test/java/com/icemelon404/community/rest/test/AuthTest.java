package com.icemelon404.community.rest.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AuthTest {

    private final AuthApi api = new AuthApi("localhost", 10010);
    private final AuthApi.User user = new AuthApi.User("test", "test@test.com", "testPassword");

    @Test
    public void register() {
        Assertions.assertEquals(200, api.register(user));
    }

    @Test
    public void login() {
        String authToken = api.login(user);
        System.out.println(authToken);
        Assertions.assertNotNull(authToken);
        Assertions.assertEquals("BEARER", authToken.split(" ")[0]);
    }
}
