package com.backend.forms.service;

import com.backend.forms.execptions.ApiResponse;
import com.backend.forms.execptions.ExceptionMessage;
import com.backend.forms.models.AnswerModel;
import com.backend.forms.models.QuestionModel;
import com.backend.forms.repository.AnswerRepo;
import com.backend.forms.repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepo questionRepo;
    private AnswerRepo answerRepo;

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

    // Answer section
    @Transactional
    public ApiResponse createAnswer(AnswerModel answerModel) {
        try {
            answerRepo.saveAnswer(
                    answerModel.question_id,
                    answerModel.selected_option_id,
                    answerModel.answer_text
            );
            return new ApiResponse("Answer saved correctly");
        } catch (Exception e) {
            throw new ExceptionMessage("Error saving the answer" + e.getMessage(), 1002);
        }
    }
}