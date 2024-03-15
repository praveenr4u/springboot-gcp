package com.pr.springbootcloudrun.controller;

import com.pr.springbootcloudrun.dto.UserDto;
import com.pr.springbootcloudrun.entity.UserEntity;
import com.pr.springbootcloudrun.repository.UserDataService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserDataService userService;

    public UserController(UserDataService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{username}")
    public UserEntity getUser(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @PostMapping("/user")
    public UserEntity createUser(@RequestBody UserEntity userDTO) {
        return userService.add(userDTO);
    }

    @GetMapping("/users")
    public List<UserEntity> getUsers() {
        return userService.getAll();
    }

}