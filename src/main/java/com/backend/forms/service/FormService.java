package com.backend.forms.service;

import com.backend.forms.execptions.ApiResponse;
import com.backend.forms.execptions.ExceptionMessage;
import com.backend.forms.models.FormModel;
import com.backend.forms.repository.FormRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FormService {
    @Autowired
    private FormRepo formRepo;

    @Transactional
    public ApiResponse createForm(FormModel formModel) {
       try {
           if(formModel.form_title == null || formModel.form_title.isEmpty()) {
               throw new ExceptionMessage("The form needs to have a title", 1001);
           }
           formRepo.createForm(formModel.form_title, formModel.form_description, formModel.user_id);
           return new ApiResponse("Successfully created form");
       } catch (Exception e) {
           throw new ExceptionMessage("Error creating the form" + e.getMessage(), 1002);
       }
    }

    @Transactional
    public ApiResponse updateForm(FormModel formModel) {
        try {
            if(formModel.form_title == null || formModel.form_title.isEmpty() || formModel.form_description.isEmpty()) {
                throw new ExceptionMessage("The title and description are required to update", 1001);
            }
            formRepo.updateForm(formModel.form_id, formModel.form_title, formModel.form_description);
            return new ApiResponse("Update form data");
        } catch (Exception e) {
            throw new ExceptionMessage("Error updating form data" + e.getMessage(), 1002);
        }
    }

    @Transactional
    public ApiResponse deleteForm(FormModel formModel) {
        try {
            if(formModel.form_id == null) {
                throw new ExceptionMessage("Form is is required", 1001);
            }
            formRepo.deleteForm(formModel.form_id);
            return new ApiResponse("Forms deleted");
        } catch (Exception e) {
            throw new ExceptionMessage("Error deleting form" + e.getMessage(), 1002);
        }
    }
}