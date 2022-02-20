package com.icemelon404.community.post.infra.post;


import com.icemelon404.community.post.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPostRepository extends JpaRepository<Post, Long> {

}
