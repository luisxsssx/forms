package com.backend.forms.service;

import com.backend.forms.models.UserModel;
import com.backend.forms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void saveUser(UserModel userModel){
        userRepository.saveUser(userModel.first_name, userModel.last_name, userModel.email, userModel.age);
    }

    @Transactional
    public List<UserModel> listAllUsers(){
        return userRepository.getAllUsers();
    }
}