/*
package com.usk.service;

import com.usk.dto.UserRequest;
import com.usk.entity.User;
import com.usk.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    void testRegisterUser_Success() {
        UserRequest request = new UserRequest("John", "john@example.com");
        when(userRepository.existsByEmail(request.getEmail())).thenReturn(false);

        User user = new User();
        user.setUserId(1L);
        when(userRepository.save(any(User.class))).thenReturn(user);

        String result = userService.registerUser(request);
        assertEquals("User registered successfully with id :1", result);
    }

    @Test
    void testRegisterUser_EmailExists() {
        UserRequest request = new UserRequest("John", "john@example.com");
        when(userRepository.existsByEmail(request.getEmail())).thenReturn(true);

        String result = userService.registerUser(request);
        assertEquals("Email already in use", result);
    }
}
*/
