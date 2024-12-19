package com.backend.forms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserModel {
    @Id
    public Integer user_id;
    public String first_name;
    public String last_name;
    public String email;
    public String age;
    public String password;
}