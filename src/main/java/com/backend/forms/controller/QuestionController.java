package com.backend.forms.controller;

import com.backend.forms.execptions.ApiResponse;
import com.backend.forms.models.QuestionModel;
import com.backend.forms.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> saveQuestion(@RequestBody QuestionModel questionModel) {
        try {
            ApiResponse apiResponse = questionService.createQuestion(questionModel);
            return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            ApiResponse error = new ApiResponse("Error: " + e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }
}