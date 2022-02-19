package com.upgrad.paymentservice.model.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {

    private Long id;
    private LocalDate appointmentDate;
    private LocalDateTime createdDate;
    private String doctorId;
    private String priorMedicalHistory;
    private String status;
    private String symptoms;
    private String timeSlot;
    private String userId;
    private String userMailId;
    private String userName;
    private String doctorName;
}
