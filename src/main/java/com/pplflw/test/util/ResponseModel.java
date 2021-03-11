package com.pplflw.test.util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;


public class ResponseModel<T> {

    @JsonView(JsonUtil.Views.Limited.class)
    private String status;

    @JsonView(JsonUtil.Views.Limited.class)
    private String message;

    @JsonView(JsonUtil.Views.Limited.class)
    private T data;

    public ResponseModel() {

    }

    public ResponseModel(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseModel(String status, String message, T data) {
        this(status, message);
        this.data = data;
    }

    /**
     * Checks if the message returned is successful
     *
     * @return
     */
    @JsonIgnore
    public boolean isSuccess() {
        return "00".equals(status) || "0".equals(status);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
