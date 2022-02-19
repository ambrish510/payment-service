package com.upgrad.paymentservice.model.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "payment")
public class PaymentEntity {

    @Id
    private String paymentId;
    private Long appointmentId;
    private LocalDate CreateDate;
}
