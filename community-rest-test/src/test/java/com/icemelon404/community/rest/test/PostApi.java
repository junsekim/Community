package com.icemelon404.community.rest.test;

import io.restassured.RestAssured;
import io.restassured.builder.MultiPartSpecBuilder;
import io.restassured.http.Header;
import io.restassured.specification.MultiPartSpecification;
import io.restassured.specification.RequestSpecification;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.util.List;

@RequiredArgsConstructor
public class PostApi {

    private final String HOST;
    private final int POST_PORT;


    public int uploadPost(List<File> images, String content, String authToken) {
        RequestSpecification request = RestAssured.given()
                .header("content-type", "multipart/form-data");
        for (File image : images)
            request = request.multiPart(multipartImage(image));
        request = request.multiPart("content", content);
        if (authToken != null)
            request = request.header(new Header("Authorization", authToken));
        return request
                .when()
                .post("http://" + HOST + ":" + POST_PORT + "/upload")
                .statusCode();
    }


    private MultiPartSpecification multipartImage(File image) {
        return new MultiPartSpecBuilder(image).
                fileName(image.getName()).
                controlName("image").
                mimeType(mimeType(image)).
                build();
    }

    private String mimeType(File image) {
        if (image.getName().endsWith(".png"))
            return "image/png";
        else if (image.getName().endsWith(".jpg"))
            return "image/jpeg";
        throw new IllegalStateException();
    }
}
