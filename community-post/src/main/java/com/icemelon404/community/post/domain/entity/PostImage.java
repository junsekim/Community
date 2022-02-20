package com.icemelon404.community.post.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class    PostImage {

    @Column(name = "url")
    @Getter
    private String imageId;

}
