package com.usk.controller;

import com.usk.dto.UserRequest;
import com.usk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public String registerUser(@RequestBody UserRequest userRequest){
        return  userService.registerUser(userRequest);

    }

}
