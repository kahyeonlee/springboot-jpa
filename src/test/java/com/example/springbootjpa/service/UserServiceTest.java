package com.example.springbootjpa.service;

import com.example.springbootjpa.dto.UserRequest;
import com.example.springbootjpa.dto.UserResponse;
import com.example.springbootjpa.model.User;
import com.example.springbootjpa.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class UserServiceTest {

    private UserRepository userRepository = Mockito.mock(UserRepository.class);

    private UserService userService;
    @BeforeEach
    void setUp(){
        userService = new UserService(userRepository); //수동 di
    }
    @Test
    @DisplayName("횐원 드록 성공메세지가 나오는지")
    void addTest() {
        Mockito.when(userRepository.save(any()))
                .thenReturn(new User(1l,"kahyun","s1234"));
        UserResponse userResponse = userService.addUser(new UserRequest("kahyun", "s1234"));
        Assertions.assertEquals("회원 등록 성공", userResponse.getMessage());
        Assertions.assertEquals("kahyun", userResponse.getUsername());
    }
}