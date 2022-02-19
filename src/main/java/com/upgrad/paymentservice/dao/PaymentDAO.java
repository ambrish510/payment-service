package com.upgrad.paymentservice.dao;

import com.upgrad.paymentservice.model.entity.PaymentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDAO extends MongoRepository<PaymentEntity, String> {
}
