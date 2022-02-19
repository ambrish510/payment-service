package com.upgrad.paymentservice.model.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ErrorResponse {
    private String errorCode;
    private String errorMessage;
    private List<String> errorDetails;

    public ErrorResponse(String errorCode, String errorMessage, List<String> errorDetails) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorDetails = errorDetails;
    }
}
