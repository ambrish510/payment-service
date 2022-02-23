package com.upgrad.paymentservice.service;

import com.upgrad.paymentservice.dao.PaymentDAO;
import com.upgrad.paymentservice.feign.AppointmentServiceClient;
import com.upgrad.paymentservice.feign.SecurityServiceClient;
import com.upgrad.paymentservice.model.JwtTokenRequest;
import com.upgrad.paymentservice.model.dto.AppointmentDTO;
import com.upgrad.paymentservice.model.entity.AppointmentEntity;
import com.upgrad.paymentservice.model.entity.PaymentEntity;
import org.modelmapper.ModelMapper;
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

    @Autowired
    SecurityServiceClient securityServiceClient;

    @Autowired
    JwtTokenRequest jwtTokenRequest;

    @Autowired
    ModelMapper modelMapper;

    public PaymentEntity makePayment(Long appointmentId) {

        PaymentEntity paymentEntity = new PaymentEntity();
        JwtTokenRequest token = new JwtTokenRequest("normal-user@abc.com", "Test@123");
        String authToken = securityServiceClient.generateToken(token);
        System.out.println(token.toString());
        System.out.println(authToken);
        ResponseEntity<AppointmentDTO> appointmentDTO = appointmentServiceClient.getAppointment(appointmentId, authToken);
        System.out.println(appointmentDTO.toString());
        paymentEntity.setPaymentId(UUID.randomUUID().toString());
        paymentEntity.setAppointmentId(appointmentId);
        paymentEntity.setCreateDate(LocalDate.now());
        System.out.println(appointmentDTO.toString());
        ResponseEntity<AppointmentEntity> appointment = appointmentServiceClient.updateAppointment(appointmentId, appointmentDTO, authToken);
        System.out.println(appointment.toString());
        System.out.println(paymentEntity.toString());
        return paymentDAO.save(paymentEntity);
    }
}
