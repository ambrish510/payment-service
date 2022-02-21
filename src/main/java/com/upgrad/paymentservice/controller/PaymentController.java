package com.upgrad.paymentservice.controller;

import com.upgrad.paymentservice.model.dto.PaymentDTO;
import com.upgrad.paymentservice.model.entity.PaymentEntity;
import com.upgrad.paymentservice.service.PaymentService;
import com.upgrad.paymentservice.service.TokenProvider;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    TokenProvider tokenProvider;

    @PostMapping(value = "/payments", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<PaymentDTO> postPayment(@RequestParam Long appointmentId,@RequestHeader String authorization){

        System.out.println(authorization);
        tokenProvider.validateToken(authorization);
        PaymentEntity paymentEntity = paymentService.makePayment(appointmentId);
        PaymentDTO paymentDTO = modelMapper.map(paymentEntity,PaymentDTO.class);
        return new ResponseEntity<>(paymentDTO, HttpStatus.CREATED);
    }
}
