package com.backend.forms.service;

import com.backend.forms.execptions.ApiResponse;
import com.backend.forms.execptions.ExceptionMessage;
import com.backend.forms.models.UserModel;
import com.backend.forms.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    private final BCryptPasswordEncoder passwordEncoder;

    public UserService() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }

    @Transactional
    public ApiResponse saveUser(UserModel userModel){
        String encryptedPassword = passwordEncoder.encode(userModel.password);
        try {
          userRepo.saveUser(userModel.first_name, userModel.last_name, userModel.email, userModel.age, encryptedPassword);
            return new ApiResponse("User created correctly");
        } catch (Exception e) {
          throw new ExceptionMessage("Error creating user" + e.getMessage(), 1002);
      }
    }

    @Transactional
    public void updateUser(UserModel userModel) {
        try {
            userRepo.updateUser(userModel.user_id, userModel.first_name, userModel.last_name, userModel.email, userModel.age);
        } catch (Exception e) {
            throw new ExceptionMessage("Failed update to data" + e.getMessage(), 1002);
        }
    }

    @Transactional
    public void updatePassword(UserModel userModel) {
        String encryptedPassword = passwordEncoder.encode(userModel.password);
        try {
            userRepo.updatePassword(userModel.user_id, encryptedPassword);
        } catch (Exception e) {
            throw new ExceptionMessage("Failed update to password" + e.getMessage(), 1002);
        }
    }

    @Transactional
    public void deleteUser(UserModel userModel) {
        try {
            userRepo.deleteUser(userModel.user_id);
        } catch (Exception e) {
            throw new ExceptionMessage("Error deleting user" + e.getMessage(), 1002);
        }
    }

    @Transactional
    public List<UserModel> listAllUsers(){
        return userRepo.getAllUsers();
    }
}