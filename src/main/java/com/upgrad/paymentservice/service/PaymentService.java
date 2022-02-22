package com.upgrad.paymentservice.service;

import com.upgrad.paymentservice.dao.PaymentDAO;
import com.upgrad.paymentservice.dao.UserRepo;
import com.upgrad.paymentservice.exception.AppException;
import com.upgrad.paymentservice.feign.AppointmentServiceClient;
import com.upgrad.paymentservice.model.entity.AppointmentEntity;
import com.upgrad.paymentservice.model.entity.PaymentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    PaymentDAO paymentDAO;

    @Autowired
    AppointmentServiceClient appointmentServiceClient;

    public PaymentEntity makePayment(Long appointmentId) {

        PaymentEntity paymentEntity = new PaymentEntity();
        ResponseEntity<AppointmentEntity> appointmentEntityResponseEntity = appointmentServiceClient.getAppointment(appointmentId);
        paymentEntity.setPaymentId(UUID.randomUUID().toString());
        paymentEntity.setAppointmentId(appointmentId);
        paymentEntity.setCreateDate(LocalDate.now());
        ResponseEntity<AppointmentEntity> appointment = appointmentServiceClient.updateAppointment(appointmentId, appointmentEntityResponseEntity);
        return paymentDAO.save(paymentEntity);
    }
}
