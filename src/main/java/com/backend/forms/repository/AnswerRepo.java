package com.backend.forms.repository;

import com.backend.forms.models.AnswerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepo extends JpaRepository<AnswerModel, Integer> {

    @Modifying
    @Query(value = "CALL save_answer(:p_question_id, :p_selected_option, :p_answer_text)", nativeQuery = true)
    void saveAnswer(
            @Param("p_question_id") Integer questionId,
            @Param("p_selected_option") Integer selectedOption,
            @Param("p_answer_text") String answerText
    );

    // options section
    @Modifying
    @Query(value = "CALL save_options(:question_id, :option_text)", nativeQuery = true)
    void save_options(
            @Param("question_id") Integer questionId,
            @Param("option_text") String optionText
    );
}