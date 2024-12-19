package com.backend.forms.controller;

import com.backend.forms.models.UserModel;
import com.backend.forms.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/forms/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserModel> saveUsers(@RequestBody UserModel userModel) {
        userService.saveUser(userModel);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserModel>> listUsers(){
        List<UserModel> users = userService.listAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/update/data")
    public ResponseEntity<UserModel> updateUser(@RequestBody UserModel userModel) {
        userService.updateUser(userModel);
        return ResponseEntity.status(200).build();
    }

    @PostMapping("/update/password")
    public ResponseEntity<UserModel> updatePassword(@RequestBody UserModel userModel) {
        userService.updatePassword(userModel);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<UserModel> deleteUser(@RequestBody UserModel userModel) {
        userService.deleteUser(userModel);
        return ResponseEntity.status(200).build();
    }

}