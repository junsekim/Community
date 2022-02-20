package com.icemelon404.community.post.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "post")
@NoArgsConstructor
public class Post {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Getter
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "image")
    @OrderColumn
    private List<PostImage> images = new LinkedList<>();

    @Getter
    @Column(name = "content", nullable = false)
    private String content = "";

    @Getter
    @Column(name = "author_id", nullable = false)
    private Long authorId = null;

    @Builder
    public Post(long authorId, String content, List<PostImage> images) {
        this.authorId = authorId;
        this.content = content;
        this.images = images;
    }
}
