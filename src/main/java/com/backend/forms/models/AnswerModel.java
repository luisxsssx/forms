package com.backend.forms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class AnswerModel {
    @Id
    public Integer answer_id;
    public Integer question_id;
    public Integer selected_option_id;
    public String answer_text;
    public LocalDateTime created_at;
}