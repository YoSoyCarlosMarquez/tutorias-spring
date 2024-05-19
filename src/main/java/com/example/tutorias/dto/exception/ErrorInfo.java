package com.example.tutorias.dto.exception;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.example.tutorias.dto.ResponseDto;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@RequiredArgsConstructor(staticName = "create")
public class ErrorInfo implements Serializable {

    private static final long serialVersionUID = 7074808751192877967L;

    /**
     * The HTTP status code
     */
    @NonNull
    private Integer status;
    /**
     * The error message associated with exception
     */
    @NonNull
    private String message;
    /**
     * List of constructed error messages
     */
    @NonNull
    private String details;
    /**
     * Date and time the exception occurred
     */
    private LocalDateTime timestamp = LocalDateTime.now();

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public static ErrorInfo create(int status, String message, String details) {
        ErrorInfo dto = new ErrorInfo();
        dto.setStatus(status);
        dto.setMessage(message);
        dto.setDetails(details);
        return dto;
    }
}
