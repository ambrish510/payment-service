package com.upgrad.paymentservice.exception;

import com.upgrad.paymentservice.model.dto.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    private String errorCode;
    private String errorMessage;

    @ExceptionHandler({AppException.class})
    public final ResponseEntity<ErrorResponse> handleDoctorNotFoundException(AppException e) {
        String errorCode = "ERR_RESOURCE_NOT_FOUND";
        List<String> errorFields = null;
        ErrorResponse errorResponse = new ErrorResponse(errorCode, e.getLocalizedMessage(), errorFields);
        System.out.println(errorResponse.toString());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
