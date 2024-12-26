package com.backend.forms.controller;

import com.backend.forms.execptions.ApiResponse;
import com.backend.forms.models.OptionModel;
import com.backend.forms.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/forms/options")
public class OptionController {
    @Autowired
    private OptionService optionService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> saveOptions(@RequestBody OptionModel optionModel) {
        try {
            ApiResponse apiResponse = optionService.saveOption();
            return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            ApiResponse error = new ApiResponse("Error: " + e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<ApiResponse> updateOptions(@RequestBody OptionModel optionModel) {
        try {
            ApiResponse apiResponse = optionService.updateOptions();
            return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            ApiResponse error = new ApiResponse("Error: " + e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<ApiResponse> deleteOption(@RequestBody OptionModel optionModel) {
        try {
            ApiResponse apiResponse = optionService.deleteOption();
            return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            ApiResponse error = new ApiResponse("Error: " + e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }
}