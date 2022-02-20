package com.icemelon404.community.post.domain.push;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@ToString
public class AuthorInfo implements Serializable {
    private long authorId;
    private long postId;


}
