package com.example.hexagonalArchitecture.emailCert.adapter.in.kafka;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class CreateEmailCertRequest {
    private Map<String, String> record;
    /*
        Kafka producer에서 topic --emailcert로 message를 보낼 때
        email:test01@gmail.com
        위 양식으로 입력하고 이를 parsing해서
        key는 email
        value는 test01@gmail.com으로 보내기 때문에
        이를 받기 위해서 Map<String, String> 형태로 Request를 구현함.
    */
}
