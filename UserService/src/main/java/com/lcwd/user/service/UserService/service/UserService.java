package com.lcwd.user.service.UserService.service;

import com.lcwd.user.service.UserService.entities.User;

import java.util.List;

public interface UserService {
//    user operation create

//    create user
    User saveUser(User user);

//    getAll user
    List<User> getAllUser();

//    getSingle user of given UserId;
    User getSingleUser(String userId);

//    delete user
    void deleteById(String id);

//    update user
    User updateUser(User user, String id);
}
