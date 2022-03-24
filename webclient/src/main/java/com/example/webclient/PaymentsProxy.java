package com.example.webclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class PaymentsProxy {

  private final WebClient webClient;

  @Value("${name.service.url}")
  private String url;

  @Autowired
  public PaymentsProxy(WebClient webClient) {
    this.webClient = webClient;
  }

  public Mono<Payment> createPayment(String requestId, Payment payment) {
    return webClient.post()
        .uri(url + "/payment")
        .header("requestId", requestId)
        .body(Mono.just(payment), Payment.class)
        .retrieve()
        .bodyToMono(Payment.class);
  }
}