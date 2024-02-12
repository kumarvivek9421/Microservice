package com.lcwd.user.service.UserService.controller;

import com.lcwd.user.service.UserService.entities.User;
import com.lcwd.user.service.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

//    create (URL= http://localhost:8080/api/users)
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1= userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

//    getSingleUser (URL= http://localhost:8080/api/users/1)
    @GetMapping("/{id}")
    public ResponseEntity<User> getSingleUser(@PathVariable("id") String userId){
        User singleUser = userService.getSingleUser(userId);
        return ResponseEntity.ok(singleUser);
    }

//    getAllUsers (URL= http://localhost:8080/api/users)
    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUser= userService.getAllUser();

        return ResponseEntity.ok(allUser);
    }

//    deleteUserById (URL= http://localhost:8080/api/users/id)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") String userId){
        userService.deleteById(userId);
        return new ResponseEntity<>("User is deleted", HttpStatus.OK);
    }

    //    updateUserById (URL= http://localhost:8080/api/users/id)
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable String id) {
        User updatedUser = userService.updateUser(user, id);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}
