package com.backend.forms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OptionModel {
    @Id
    public Integer optionId;
    public Integer question_id;
    public String option_text;
}