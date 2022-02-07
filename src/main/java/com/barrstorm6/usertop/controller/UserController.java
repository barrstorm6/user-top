package com.barrstorm6.usertop.controller;

import com.barrstorm6.usertop.model.User;
import com.barrstorm6.usertop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userInfo/{userId}")
    public List<User> getAllByUserId(@PathVariable Integer userId) {
        return userService.getAllByUserId(userId);
    }

    @GetMapping("/levelId/{levelId}")
    public Object getAllByLevelId(@PathVariable Integer levelId) {
        return userService.getAllByLevelId(levelId);
    }

    @PutMapping("/setInfo")
    public void addUser(@RequestBody User user) {
        userService.saveUser(user);
    }
}
