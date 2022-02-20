package com.icemelon404.community.auth.infa;

import com.icemelon404.community.auth.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaUserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUserName(String userName);
}
