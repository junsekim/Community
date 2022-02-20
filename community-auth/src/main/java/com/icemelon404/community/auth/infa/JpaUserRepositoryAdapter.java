package com.icemelon404.community.auth.infa;

import com.icemelon404.community.auth.domain.entity.User;
import com.icemelon404.community.auth.domain.login.UserReader;
import com.icemelon404.community.auth.domain.register.UserStore;
import com.icemelon404.community.commons.exception.DuplicateResourceException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Optional;

@RequiredArgsConstructor
public class JpaUserRepositoryAdapter implements UserReader, UserStore {

    private final JpaUserRepository repository;

    @Override
    public Optional<User> findUserByUserName(String userName) {
        return repository.findUserByUserName(userName);
    }

    @Override
    public User save(User user) {
        try {
            return repository.saveAndFlush(user);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateResourceException(user.getUserName() + " , " + user.getMailAddress() + " 는 이미 존재하는 유저입니다");
        }
    }
}
