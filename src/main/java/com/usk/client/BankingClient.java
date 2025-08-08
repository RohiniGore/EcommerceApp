package com.usk.client;

import com.usk.dto.PaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "banking-service", url = "http://localhost:8083/api/banking")
public interface BankingClient {
    @PostMapping("/verify" )
    String verifyAndDeduct(@RequestBody PaymentRequest request);
}
