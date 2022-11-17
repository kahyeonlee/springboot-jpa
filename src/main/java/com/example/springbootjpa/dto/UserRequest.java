package com.example.springbootjpa.dto;


import com.example.springbootjpa.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String username;
    private String password;

    public User toEntity() {
        User user = User.builder()
                .username(this.username)
                .password(this.password)
                .build();
        return user;
    }

}