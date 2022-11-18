package com.example.springbootjpa.repository;

import com.example.springbootjpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //중복체크
    Optional <User> findByUsername(String username);

}
