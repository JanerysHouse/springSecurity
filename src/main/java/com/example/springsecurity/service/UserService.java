package com.example.springsecurity.service;

import com.example.springsecurity.entity.UserEntity;
import com.example.springsecurity.repository.UserRepository;
import lombok.Builder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Builder
public class UserService {
     UserRepository userRepository;
    private BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    public void saveUser(UserEntity userEntity){
        userEntity.setPassword(encoder().encode(userEntity.getPassword()));
        userRepository.save(userEntity);
    }


    public List<UserEntity> getAll() {
       return userRepository.findAll();
    }
}
