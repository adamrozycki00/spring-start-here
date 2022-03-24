package com.example.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class PaymentsProxy {

  private final RestTemplate rest;

  @Value("${name.service.url}")
  private String url;

  @Autowired
  public PaymentsProxy(RestTemplate rest) {
    this.rest = rest;
  }

  public Payment createPayment(String requestId, Payment payment) {
    var headers = new HttpHeaders();
    headers.add("requestId", requestId);

    return rest.exchange(url + "/payment",
            HttpMethod.POST,
            new HttpEntity<>(payment, headers),
            Payment.class)
        .getBody();
  }
}