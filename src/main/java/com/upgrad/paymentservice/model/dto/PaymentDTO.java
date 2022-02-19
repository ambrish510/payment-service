package com.upgrad.paymentservice.model.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {
    private String paymentId;
    private Long appointmentId;
    private LocalDate CreateDate;
}
