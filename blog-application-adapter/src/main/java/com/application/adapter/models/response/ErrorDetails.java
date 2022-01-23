package com.application.adapter.models.response;

import java.util.Date;
import java.util.List;

public class ErrorDetails {

    private Date timestamp;
    private String message;
    private List<String> details;

    private ErrorDetails() {}

    public static ErrorDetails init() {
        return new ErrorDetails();
    }

    public ErrorDetails setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public ErrorDetails setMessage(String message) {
        this.message = message;
        return this;
    }

    public ErrorDetails setDetails(List<String> details) {
        this.details = details;
        return this;
    }

    @Override
    public String toString() {
        return "ErrorDetails{" +
                "timestamp=" + timestamp +
                ", message='" + message + '\'' +
                ", details=" + details +
                '}';
    }
}
