package com.backend.forms.execptions;

public class ExceptionMessage extends RuntimeException {
    private final int errorCode;
    public ExceptionMessage(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    public int getErrorCode() {
        return errorCode;
    }
}
