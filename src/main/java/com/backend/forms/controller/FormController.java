package com.backend.forms.controller;

import com.backend.forms.execptions.ApiResponse;
import com.backend.forms.execptions.ExceptionMessage;
import com.backend.forms.models.FormModel;
import com.backend.forms.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/forms")
public class FormController {
    @Autowired
    private FormService formService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createForm(@RequestBody FormModel formModel){
        try {
            ApiResponse response = formService.createForm(formModel);
            return new ResponseEntity<>(response, HttpStatus.CREATED); 
        } catch (ExceptionMessage ex) {
            ApiResponse errorResponse = new ApiResponse("Error: " + ex.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<ApiResponse> updateForm(@RequestBody FormModel formModel) {
        try {
            ApiResponse response = formService.updateForm(formModel);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (ExceptionMessage e) {
            ApiResponse errorResponse = new ApiResponse("Error: " + e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse> deleteForm(@RequestBody FormModel formModel) {
        try {
            ApiResponse response = formService.deleteForm(formModel);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (ExceptionMessage e) {
            ApiResponse errorResponse = new ApiResponse("Error: " + e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

}