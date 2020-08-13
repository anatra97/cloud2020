package com.wyl.sc.controller;

import com.sun.media.jfxmedia.logging.Logger;
import com.wyl.sc.entities.CommonResult;
import com.wyl.sc.entities.Payment;
import com.wyl.sc.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;


    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {

        int result = paymentService.create(payment);
        log.info("******插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,serverPort:"+serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败");
        }

    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("******插入结果：" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功,serverPort:"+serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录，查询id:" + id, null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }
}
