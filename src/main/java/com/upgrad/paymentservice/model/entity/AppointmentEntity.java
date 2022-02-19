package com.upgrad.paymentservice.model.entity;

import com.upgrad.paymentservice.model.PaymentStatus;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Appointment")
public class AppointmentEntity {
    @Id
    @Column(name = "appointment_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "appointment_date", nullable = true)
    private LocalDate appointmentDate;

    @Column(name = "created_date", nullable = true)
    private LocalDateTime createdDate;

    @Column(name = "doctor_id", nullable = true)
    private String doctorId;

    @Column(name = "prior_medical_history", nullable = true)
    private String priorMedicalHistory;

    @Column(name = "status", nullable = true)
    PaymentStatus status;

    @Column(name = "sysptoms", nullable = true)
    private String symptoms;

    @Column(name = "time_slot", nullable = true)
    private String timeSlot;

    @Column(name = "user_id", nullable = true)
    private String userId;

    @Column(name = "user_mail_id", nullable = true)
    private String userMailId;

    @Column(name = "user_name", nullable = true)
    private String userName;

    @Column(name = "doctor_name", nullable = true)
    private String doctorName;
}
