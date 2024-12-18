package com.backend.forms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class FormModel {
        @Id
        public Integer form_id;
        public String form_title;
        public String form_description;
        public Date created_at;
        public Integer user_id;
}