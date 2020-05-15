package com.sandbox.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Nikolay Chechenko.
 * @since 14.05.2020
 */
@Entity
@Table(name = "sandbox_user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String login;
    @Column
    private String password;
    @Column
    private String email;

}
