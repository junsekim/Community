package com.icemelon404.community.rest.test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthApi {
    private final String HOST;
    private final int PORT;

    public String registerAndLogin(User user) {
        register(user);
        return login(user);
    }

    public int register(User user) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(user)
                .post("http://" + HOST + ":" + PORT + "/auth/register")
                .statusCode();
    }

    public String login(User user) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(new Login(user.userName, user.password))
                .post("http://" + HOST + ":" + PORT + "/auth/login")
                .getHeader("Authorization");
    }

    @RequiredArgsConstructor
    @Getter
    static class Login {
        private final String userName;
        private final String password;
    }

    @RequiredArgsConstructor
    @Getter
    static class User {
        private final String userName;
        private final String mailAddress;
        private final String password;
    }
}
