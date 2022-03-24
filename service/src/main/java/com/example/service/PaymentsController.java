package com.example.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;

@RestController
public class PaymentsController {

  private static final Logger logger = getLogger(PaymentsController.class.getName());

  @PostMapping("/payment")
  public ResponseEntity<Payment> createPayment(
      @RequestHeader String requestId,
      @RequestBody Payment payment) {
    logger.info("Received request with ID " + requestId + "; Payment Amount: " + payment.getAmount());

    payment.setId(requestId);
    String randomUuid = UUID.randomUUID().toString();

    return ResponseEntity
        .status(HttpStatus.OK)
        .header("requestId", randomUuid)
        .body(payment);
  }
}