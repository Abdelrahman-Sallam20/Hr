package com.example.hr.error;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ErrorResponse {

    private String message;
    private String statusCode;
    private Date time;
    private List<String> details;

    public ErrorResponse(String message, String statusCode, List<String> details) {
        this.message = message;
        this.statusCode = statusCode;
        this.time = new Date();
        this.details = details;
    }

    public ErrorResponse() {
    }

}
