package com.icemelon404.community.rest.test;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

public class PostUploadTest {

    private final File image0 = new File("img.png");
    private final File image1 = new File("img_1.png");
    private final List<File> images = List.of(image0, image1);
    private final PostApi postApi = new PostApi("localhost", 9020);
    private final AuthApi authApi = new AuthApi("localhost", 10010);
    private final AuthApi.User user = new AuthApi.User("testUserName", "testUser@test.com", "testPassword");

    @Test
    public void uploadWithOutAuth() {
        Assertions.assertEquals(HttpStatus.SC_FORBIDDEN, postApi.uploadPost(images, "test content", null));
    }


    @Test
    public void uploadWithAuth() {
        String authToken = authApi.registerAndLogin(user);
        Assertions.assertEquals(HttpStatus.SC_OK, postApi.uploadPost(images, "test content", authToken));
    }

}
