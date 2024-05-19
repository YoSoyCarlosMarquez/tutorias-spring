package com.example.tutorias.dto.constants;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Map;

@Getter
@Component
public class Message implements Serializable {

    private static final long serialVersionUID = 1652359669445648982L;

    @Value("${message.exception.general}")
    private String general;

    private String unauthorized;

    private String forbidden;

    @Value("${message.exception.nofound}")
    private String noFound;

    private String inconsistency;

    @Value("${message.exception.badrequest}")
    private String badRequest;

    private String methodNoAllow;

    private String missingServletRequestParameter;

    @Value("${message.exception.constraintviolation}")
    private String constraintViolation;

    private String argumentTypeMismatch;

    private String mediaTypeNoSupported;

    private String customNoData;

    private String nullField;

    private String noNullField;

    private String customExistData;

    public String getMessage(String message, Map<String, String> parameters) {
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            String parameter = entry.getKey();
            String value = entry.getValue();
            message = message.replace(parameter, value);
        }
        return message;
    }

    public String getGeneral() {
        return general;
    }

    public void setGeneral(String general) {
        this.general = general;
    }

    public String getUnauthorized() {
        return unauthorized;
    }

    public void setUnauthorized(String unauthorized) {
        this.unauthorized = unauthorized;
    }

    public String getForbidden() {
        return forbidden;
    }

    public void setForbidden(String forbidden) {
        this.forbidden = forbidden;
    }

    public String getNoFound() {
        return noFound;
    }

    public void setNoFound(String noFound) {
        this.noFound = noFound;
    }

    public String getInconsistency() {
        return inconsistency;
    }

    public void setInconsistency(String inconsistency) {
        this.inconsistency = inconsistency;
    }

    public String getBadRequest() {
        return badRequest;
    }

    public void setBadRequest(String badRequest) {
        this.badRequest = badRequest;
    }

    public String getMethodNoAllow() {
        return methodNoAllow;
    }

    public void setMethodNoAllow(String methodNoAllow) {
        this.methodNoAllow = methodNoAllow;
    }

    public String getMissingServletRequestParameter() {
        return missingServletRequestParameter;
    }

    public void setMissingServletRequestParameter(String missingServletRequestParameter) {
        this.missingServletRequestParameter = missingServletRequestParameter;
    }

    public String getConstraintViolation() {
        return constraintViolation;
    }

    public void setConstraintViolation(String constraintViolation) {
        this.constraintViolation = constraintViolation;
    }

    public String getArgumentTypeMismatch() {
        return argumentTypeMismatch;
    }

    public void setArgumentTypeMismatch(String argumentTypeMismatch) {
        this.argumentTypeMismatch = argumentTypeMismatch;
    }

    public String getMediaTypeNoSupported() {
        return mediaTypeNoSupported;
    }

    public void setMediaTypeNoSupported(String mediaTypeNoSupported) {
        this.mediaTypeNoSupported = mediaTypeNoSupported;
    }

    public String getCustomNoData() {
        return customNoData;
    }

    public void setCustomNoData(String customNoData) {
        this.customNoData = customNoData;
    }

    public String getNullField() {
        return nullField;
    }

    public void setNullField(String nullField) {
        this.nullField = nullField;
    }

    public String getNoNullField() {
        return noNullField;
    }

    public void setNoNullField(String noNullField) {
        this.noNullField = noNullField;
    }

    public String getCustomExistData() {
        return customExistData;
    }

    public void setCustomExistData(String customExistData) {
        this.customExistData = customExistData;
    }
}
