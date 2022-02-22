package com.upgrad.paymentservice.feign;

import com.upgrad.paymentservice.model.dto.AppointmentDTO;
import com.upgrad.paymentservice.model.entity.AppointmentEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "appointment-service", url = "http://localhost:8083/appointment-service")
public interface AppointmentServiceClient {

    @PutMapping(value = "/appointments/update/{appointmentId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppointmentEntity> updateAppointment(@PathVariable Long appointmentId, @RequestBody ResponseEntity<AppointmentDTO> appointmentDTO, @RequestHeader String authorization);

    @GetMapping(value = "/appointments/{appointmentId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppointmentDTO> getAppointment(@PathVariable Long appointmentId,@RequestHeader String authorization);
}
