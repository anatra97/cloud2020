package com.wyl.sc.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfo_ok(Integer id) {
        return "-----PaymentFallbackService   ok";
    }

    @Override
    public String paymentInfo_timeout(Integer id) {
        return "-----PaymentFallbackService   timeout";
    }
}
