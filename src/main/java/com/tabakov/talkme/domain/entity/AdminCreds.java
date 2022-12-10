package com.tabakov.talkme.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "admin_creds")
@Getter
@Setter
public class AdminCreds {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "creds_id", nullable = false)
    private Long id;

    @Column(name = "login")
    private String login = "admin";

    @Column(name = "password")
    private String password = "password";
}
