package com.upgrad.paymentservice.controller;

import com.upgrad.paymentservice.model.dto.PaymentDTO;
import com.upgrad.paymentservice.model.entity.PaymentEntity;
import com.upgrad.paymentservice.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping(value = "/payments")
    @ResponseBody
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<PaymentDTO> postPayment(@RequestParam Long appointmentId) {

        PaymentEntity paymentEntity = paymentService.makePayment(appointmentId);
        PaymentDTO paymentDTO = modelMapper.map(paymentEntity, PaymentDTO.class);
        return new ResponseEntity<>(paymentDTO, HttpStatus.CREATED);
    }
}
