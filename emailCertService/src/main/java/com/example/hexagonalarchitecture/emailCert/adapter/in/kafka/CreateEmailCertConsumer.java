package com.example.hexagonalarchitecture.emailCert.adapter.in.kafka;

import com.example.hexagonalarchitecture.common.ExternalSystemAdapter;

import com.example.hexagonalarchitecture.emailCert.application.port.in.CreateEmailCertCommand;
import com.example.hexagonalarchitecture.emailCert.application.port.in.CreateEmailCertUseCase;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;


@ExternalSystemAdapter
@RequiredArgsConstructor
public class CreateEmailCertConsumer {
    private final CreateEmailCertUseCase createEmailCertUseCase;

    // listener로서 kafka 메세지를 받을 수 있는 annotation
    // 원래는 controller로 하지만 이 코드에서는 Spring Cloud Kafka의 기본 annotation을 사용해
    // Kafka producer에서 보내는 topic message를 받는 기능을 한다.
    @KafkaListener(topics = "emailcert", groupId = "emailcert-group-00")
    void createEmailCert(ConsumerRecord<String, String> record) {
        CreateEmailCertCommand command = CreateEmailCertCommand.builder()
                .email(record.value())
                .build();
        System.out.println(record.toString());

        createEmailCertUseCase.createEmailCert(command);
    }
    /**
     *  Zookeeper 서버, Kafka 서버를 모두 실행시킨 후
     *  Kafka Producer, Consumer 서버를 모두 실행시킨 후
     *  Kafka producer에서 topic --emailcert로 message를 보내면
     *  그 emailcert로 온 topic을 받아서 email을 뽑아서
     *  이메일 인증을 하는 일련의 과정이 CreateEmailCert 관련 코드이다.
     *
     *  VerifyEmailCert 관련 코드는
     *  회원 가입 후 외부 어댑터를 통해, OpenFeign을 통해 emailCertService에 요청을 보내고
     *  이를 받아서 db에 있는 email, uuid값과 조회해 일치하면
     *  이메일 인증 처리를 하는 일련의 과정이다.
     */
}
