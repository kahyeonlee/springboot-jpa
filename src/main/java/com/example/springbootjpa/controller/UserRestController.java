package com.example.springbootjpa.controller;

import com.example.springbootjpa.dto.UserRequest;
import com.example.springbootjpa.dto.UserResponse;
import com.example.springbootjpa.model.User;
import com.example.springbootjpa.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.getUser(id));
    }

    @PostMapping
    public ResponseEntity<UserResponse> addUser(@RequestBody UserRequest dto){
        UserResponse response = userService.addUser(dto);
        return ResponseEntity.ok().body(response);
    }

}
