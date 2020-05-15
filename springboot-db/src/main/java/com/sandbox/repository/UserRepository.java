package com.sandbox.repository;

import com.sandbox.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Nikolay Chechenko.
 * @since 14.05.2020
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
