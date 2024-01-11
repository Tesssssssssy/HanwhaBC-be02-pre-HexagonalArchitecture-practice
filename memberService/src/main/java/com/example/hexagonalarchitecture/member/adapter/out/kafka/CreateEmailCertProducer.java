package com.example.hexagonalarchitecture.member.adapter.out.kafka;

import com.example.hexagonalArchitecture.common.ExternalSystemAdapter;
import com.example.hexagonalarchitecture.member.application.port.out.CreateEmailCertEventPort;
import com.example.hexagonalarchitecture.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;

@ExternalSystemAdapter
@RequiredArgsConstructor
public class CreateEmailCertProducer implements CreateEmailCertEventPort {
    private final KafkaTemplate kafkaTemplate;
    @Override
    public void createEmailCertEvent(Member member) {
        ProducerRecord<String, String> record = new ProducerRecord<>("emailcert", "email", member.getEmail());
        kafkaTemplate.send(record);
    }
}
