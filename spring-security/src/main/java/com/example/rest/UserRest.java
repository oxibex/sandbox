package com.example.rest;

import com.example.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Nikolay Chechenko.
 * @since 01.03.2021
 */
@Slf4j
@RestController
@RequestMapping(path = "rest/user")
public class UserRest {

    private static final List<UserDto> USER_LIST = List.of(
            new UserDto(1L,"login 1", "User 1"),
            new UserDto(2L,"login 2", "User 2"),
            new UserDto(3L,"login 3", "User 3"),
            new UserDto(4L,"login 4", "User 4"),
            new UserDto(5L,"login 5", "User 5")
    );


    @PreAuthorize("hasAuthority('user:read')")
    @RequestMapping(path = "{userId}")
    public UserDto findById(@PathVariable("userId") Long id){
        return USER_LIST.stream()
                .filter(user -> id.equals(user.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("User not found " + id));
    }

    @PreAuthorize("hasAuthority('user:read')")
    @GetMapping
    public List<UserDto> getAllUser() {
        return USER_LIST;
    }

    @PreAuthorize("hasAuthority('user:write')")
    @PostMapping
    public void saveUser(@RequestBody UserDto user) {
        log.info("save user");
    }

    @PreAuthorize("hasAuthority('user:write')")
    @PutMapping
    public void updateUser(@RequestBody UserDto user) {
        log.info("Update User");
    }

    @PreAuthorize("hasAuthority('user:write')")
    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        log.info("Delete user");
    }


}
