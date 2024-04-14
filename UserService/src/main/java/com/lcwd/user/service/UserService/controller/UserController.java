package com.lcwd.user.service.UserService.controller;

import com.lcwd.user.service.UserService.entities.User;
import com.lcwd.user.service.UserService.repositories.UserRepository;
import com.lcwd.user.service.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private UserService userService;

//    create (URL= http://localhost:8080/api/users)
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1= userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    //    updateUserById (URL= http://localhost:8080/api/users/id)
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable String id) {
        User updatedUser = userService.updateUser(user, id);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

//    getSingleUser (URL= http://localhost:8080/api/users/{userId})
    @GetMapping("/{userId}")
    public ResponseEntity<?> getSingleUser(@PathVariable("userId") String userId){
//        User userById = userService.getSingleUser(userId);
        Optional<User> userById = userRepo.findById(userId);
            if (userById.isPresent()) {
                return new ResponseEntity<>(userById.get(), HttpStatus.OK);
            }else{
            return new ResponseEntity<>("Sorry User with given id is not present: ", HttpStatus.NOT_FOUND);
        }
    }

//    getAllUsers (URL= http://localhost:8080/api/users)
    @GetMapping
    public ResponseEntity<?> getAllUser(){
        List<String> names = userService.getAllUser().stream().map(e -> e.getName()).sorted().collect(Collectors.toList());
        List<String> allUsers = names.stream().map(n -> n.toUpperCase()).collect(Collectors.toList());
//        String allUsersName = names.stream().map(e -> e.toUpperCase()).collect(Collectors.joining(", "));
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

//    deleteUserById (URL= http://localhost:8080/api/users/id)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") String userId){
        userService.deleteById(userId);
        return new ResponseEntity<>("User is deleted", HttpStatus.OK);
    }

}
