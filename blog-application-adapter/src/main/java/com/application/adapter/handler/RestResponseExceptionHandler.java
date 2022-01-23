package com.application.adapter.handler;

import com.application.adapter.exception.ApiException;
import com.application.adapter.models.response.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = ApiException.class)
    public final ResponseEntity<ErrorDetails> handleApiErrorException(ApiException ex, WebRequest request) {
        return new ResponseEntity<>(ErrorDetails.init()
                .setTimestamp(new Date())
                .setMessage(ex.getMessage())
                .setDetails(Arrays.asList(request.getDescription(false),Arrays.toString(ex.getStackTrace()))), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = Exception.class)
    public final ResponseEntity<ErrorDetails> handleOtherException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ErrorDetails.init()
                .setTimestamp(new Date())
                .setMessage(ex.getMessage())
                .setDetails(Arrays.asList(request.getDescription(false),Arrays.toString(ex.getStackTrace()))), HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
