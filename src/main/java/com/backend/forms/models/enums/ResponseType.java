package com.backend.forms.models.enums;

public enum ResponseType {
    SHORT_ANSWER("short_answer"),
    PARAGRAPH("paragraph"),
    SINGLE_OPTION("single_option"),
    MULTIPLE_CHOICE("multiple_choice");

    ResponseType(String value) {
        this.value = value;
    }

    private final String value;

    public String getValue() {
        return value;
    }

    public static ResponseType fromValue(String value) {
        for(ResponseType type : values()) {
            if(type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw  new IllegalArgumentException("Invalid response type: " + value);
    }

}