package com.backend.forms.execptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {
    public String message;

    public ApiResponse(String message) {
        this.message = message;
    }

}