package com.backend.forms.repository;

import com.backend.forms.models.OptionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepo extends JpaRepository<OptionModel, Integer> {

    @Modifying
    @Query(value = "CALL save_options(:question_id, :option_text)", nativeQuery = true)
    void saveOptions(
            @Param("question_id") Integer questionId,
            @Param("option_text") String optionText
    );

    @Modifying
    @Query(value = "CALL update_options(:question_id, :option_text)", nativeQuery = true)
    void updateOptions(
            @Param("question_id") Integer questionId,
            @Param("option_text") String optionText
    );

    @Modifying
    @Query(value = "CALL delete_option(:option_id)", nativeQuery = true)
    void deleteOption(@Param("option_id") Integer optionId);
}