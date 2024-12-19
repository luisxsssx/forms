package com.backend.forms.service;

import com.backend.forms.models.UserModel;
import com.backend.forms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    public UserService() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }

    @Transactional
    public void saveUser(UserModel userModel){
        String encryptedPassword = passwordEncoder.encode(userModel.password);
        userRepository.saveUser(userModel.first_name, userModel.last_name, userModel.email, userModel.age, encryptedPassword);
    }

    @Transactional
    public void updateUser(UserModel userModel) {
        String encryptedPassword = passwordEncoder.encode(userModel.password);
        userRepository.updateUser(userModel.user_id, userModel.first_name, userModel.last_name, userModel.email, userModel.age);
    }

    @Transactional
    public void updatePassword(UserModel userModel) {
        String encryptedPassword = passwordEncoder.encode(userModel.password);
        userRepository.updatePassword(userModel.user_id, encryptedPassword);
    }

    @Transactional
    public void deleteUser(UserModel userModel) {
        userRepository.deleteUser(userModel.user_id);
    }

    @Transactional
    public List<UserModel> listAllUsers(){
        return userRepository.getAllUsers();
    }
}