package com.backend.forms.controller;

import com.backend.forms.models.UserModel;
import com.backend.forms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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

}