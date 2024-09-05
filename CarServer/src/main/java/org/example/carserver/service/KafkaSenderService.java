package org.example.carserver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class KafkaSenderService {

    private final KafkaTemplate<String, Long> kafkaTemplate;

    public void send(String topic, Long personId) {
        kafkaTemplate.send(topic, personId);
    }
}
