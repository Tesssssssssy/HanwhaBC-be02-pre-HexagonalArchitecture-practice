package com.example.hexagonalarchitecture.member.adapter.out.service;

import com.example.hexagonalarchitecture.member.domain.VerifyEmailCert;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "EmailCert", url = "http://localhost:8082/emailcert/verify")
public interface OpenFeignVerifyEmailCertClient {
    @GetMapping
    VerifyEmailCert call(@RequestParam String email, @RequestParam String uuid);
}
