package com.example.tutorias.exception.handler;

import com.example.tutorias.dto.ResponseDto;
import com.example.tutorias.dto.constants.Message;
import com.example.tutorias.dto.exception.ErrorInfo;
import com.example.tutorias.exception.BadRequestException;
import com.example.tutorias.exception.ForbiddenException;
import com.example.tutorias.exception.InconsistencyException;
import com.example.tutorias.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

//@Slf4j
@ControllerAdvice
//@AllArgsConstructor
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    private final Environment env;
    private final Message message;

    public GlobalExceptionHandler(Environment env, Message message) {
        this.env = env;
        this.message = message;
    }

    private static final String PACKAGE = "tutorias";
    private static final String TXT_ERROR = "ERROR - { ";
    private static final String TXT_REASON = " REASON: ";
    private static final String TXT_DETAILS = ". Más información: ";

    private ResponseEntity<ResponseDto<ErrorInfo>> response(ErrorInfo error, HttpStatus httpStatus) {
        return new ResponseEntity<>(ResponseDto.create(error), httpStatus);
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseDto<ErrorInfo>> handleResourceNotFoundException(ResourceNotFoundException e,
                                                                                  HttpServletRequest request) {
        String messageException = e.getMessage();
        log.warn(TXT_ERROR.concat(request.getMethod()).concat(" } ").concat(request.getRequestURI()).concat(TXT_REASON)
                .concat(messageException));
        return response(
                ErrorInfo.create(HttpServletResponse.SC_NOT_FOUND, message.getNoFound(), messageException),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<ResponseDto<ErrorInfo>> handleForbiddenException(ForbiddenException e,
                                                                           HttpServletRequest request) {
        String messageException = e.getMessage();
        log.warn(TXT_ERROR.concat(request.getMethod()).concat(" } ").concat(request.getRequestURI()).concat(TXT_REASON)
                .concat(messageException));
        return response(ErrorInfo.create(HttpServletResponse.SC_FORBIDDEN, message.getForbidden(), messageException),
                HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ResponseDto<ErrorInfo>> handleBadRequestException(BadRequestException e,
                                                                            HttpServletRequest request) {
        String messageException = e.getMessage();
        log.warn(TXT_ERROR.concat(request.getMethod()).concat(" } ").concat(request.getRequestURI()).concat(TXT_REASON)
                .concat(messageException));
        return response(ErrorInfo.create(HttpServletResponse.SC_BAD_REQUEST, message.getBadRequest(), messageException),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InconsistencyException.class)
    public ResponseEntity<ResponseDto<ErrorInfo>> handleInconsistencyException(InconsistencyException e,
                                                                               HttpServletRequest request) {
        String messageException = e.getMessage();
        log.warn(TXT_ERROR.concat(request.getMethod()).concat(" } ").concat(request.getRequestURI()).concat(TXT_REASON)
                .concat(messageException));
        return response(ErrorInfo.create(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message.getInconsistency(),
                messageException), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
