package com.backend.forms.repository;

import com.backend.forms.models.FormModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepo extends JpaRepository<FormModel, Long> {

    // Create Form
    @Modifying
    @Query(value = "CALL create_form(:title, :description, :user_id)", nativeQuery = true)
    void createForm(@Param("title") String formTitle,
                    @Param("description") String description,
                    @Param("user_id") Integer userId);

    // Update Form Data
    @Modifying
    @Query(value = "CALL update_form(:p_form_id, :title, :description)", nativeQuery = true)
    void updateForm(@Param("p_form_id") Integer formId,
                    @Param("title") String formTitle,
                    @Param("description") String description);

    // Delete form
    @Modifying
    @Query(value = "CALL delete_form(:form_id)", nativeQuery = true)
    void deleteForm(@Param("form_id") Integer formId);

    class QuestionRepo {
    }
}