package com.backend.forms.models;

import com.backend.forms.models.enums.ResponseType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class QuestionModel {
    @Id
    public Integer question_id;
    public Integer form_id;
    public String question_title;
    public ResponseType response_type;
    public LocalDateTime created_at;
}