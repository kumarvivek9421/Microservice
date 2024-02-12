package com.lcwd.user.service.UserService.repositories;

import com.lcwd.user.service.UserService.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
//    @Test
//    void isUserExitsById() {
//        String E123;
//        User user= new User(123, "vivek", "vivek@gmail.com");
//        userRepository.save(user);
//
//        Boolean actualResult = userRepository.isUserExitsById(Integer.valueOf("123hfu"));
//
//        assertThat(actualResult).isTrue();
//    }

}