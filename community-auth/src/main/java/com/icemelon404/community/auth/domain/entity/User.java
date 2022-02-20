package com.icemelon404.community.auth.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", unique = true)
    private String userName;

    @Column(name = "mail_address", unique = true)
    private String mailAddress;

    @Column(name = "password")
    private String password;

    @Builder
    public User(String userName, String mailAddress, String password) {
        this.userName = userName;
        this.mailAddress = mailAddress;
        this.password = password;
    }

}
