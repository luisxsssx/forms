package com.backend.forms.repository;

import com.backend.forms.models.QuestionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepo extends JpaRepository<QuestionModel, Long> {

    @Modifying
    @Query(value = "CALL create_questions(:form_id, :question_title, :response_type)", nativeQuery = true)
    void saveQuestion(@Param("form_id") Integer formId,
                      @Param("question_title") String questionTitle,
                      @Param("response_type")String responseType);
}