package com.backend.forms.service;

import com.backend.forms.execptions.ApiResponse;
import com.backend.forms.execptions.ExceptionMessage;
import com.backend.forms.models.QuestionModel;
import com.backend.forms.repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepo questionRepo;

    @Transactional
    public ApiResponse createQuestion(QuestionModel questionModel) {
        try {
            String responseType = questionModel.response_type.getValue().toLowerCase();
            questionRepo.saveQuestion(
                    questionModel.form_id,
                    questionModel.question_title,
                    responseType);
            return new ApiResponse("Question saved correctly");
        } catch (Exception e) {
            throw new ExceptionMessage("Error saving the question" + e.getMessage(),1002);
        }
    }
}