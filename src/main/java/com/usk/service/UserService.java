package com.usk.service;

import com.usk.dto.UserRequest;
import com.usk.entity.User;
import com.usk.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String registerUser(UserRequest userRequest){
        if(userRepository.existsByEmail(userRequest.getEmail())){
            return "Email already in use";
        }

        User user = new User();
        BeanUtils.copyProperties(userRequest, user);

        User savedUser = userRepository.save(user);
        return "User registered successfully with id :" + savedUser.getUserId();
    }
}
