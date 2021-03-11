package com.pplflw.test.exception;

import java.util.Date;
import java.util.Map;

public class ExceptionResponse {

    private String status;
    private Date timestamp;
    private String message;
    private String details;
    private Map<String, String> validation_error_details;


    public ExceptionResponse(String status, Date timestamp, String message, String details){
        this.status = status;
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public ExceptionResponse() {

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Map<String, String> getValidation_error_details() {
        return validation_error_details;
    }

    public void setValidation_error_details(Map<String, String> validation_error_details) {
        this.validation_error_details = validation_error_details;
    }
}
