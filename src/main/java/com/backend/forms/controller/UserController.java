package com.backend.forms.controller;

import com.backend.forms.execptions.ApiResponse;
import com.backend.forms.models.UserModel;
import com.backend.forms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<ApiResponse> saveUsers(@RequestBody UserModel userModel) {
        try {
            ApiResponse apiResponse =  userService.saveUser(userModel);
            return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            ApiResponse error = new ApiResponse("Error: " + e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
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