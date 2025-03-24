package com.jb.todo_management.exception;

import org.springframework.http.HttpStatus;

// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;
// // @AllArgsConstructor
// @NoArgsConstructor
// @Data
public class TodoAPIException extends RuntimeException
{
    private HttpStatus status;
    private String message;
    public HttpStatus getStatus() {
        return status;
    }
    public void setStatus(HttpStatus status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public TodoAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
    public TodoAPIException(String arg0, HttpStatus status, String message) {
        super(arg0);
        this.status = status;
        this.message = message;
    }
    public TodoAPIException(Throwable arg0, HttpStatus status, String message) {
        super(arg0);
        this.status = status;
        this.message = message;
    }
    public TodoAPIException(String arg0, Throwable arg1, HttpStatus status, String message) {
        super(arg0, arg1);
        this.status = status;
        this.message = message;
    }
    public TodoAPIException(String arg0, Throwable arg1, boolean arg2, boolean arg3, HttpStatus status,
            String message) {
        super(arg0, arg1, arg2, arg3);
        this.status = status;
        this.message = message;
    }
    

}
