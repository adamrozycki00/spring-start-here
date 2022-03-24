package com.example.webclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static java.util.UUID.randomUUID;

@RestController
public class PaymentsController {

  private final PaymentsProxy paymentsProxy;

  @Autowired
  public PaymentsController(PaymentsProxy paymentsProxy) {
    this.paymentsProxy = paymentsProxy;
  }

  @PostMapping("/payment")
  public Mono<Payment> createPayment(@RequestBody Payment payment) {
    String requestId = randomUUID().toString();
    return paymentsProxy.createPayment(requestId, payment);
  }
}
