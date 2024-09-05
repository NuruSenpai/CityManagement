package org.example.citymanagement.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class KafkaConsumerService {

    private final PersonService personService;

    @KafkaListener(topics = "restore-person", groupId = "person-service")
    public void listen(Long personId) {
        System.out.println("Received personId: " + personId);
        personService.restorePersonStatus(personId);
    }
}
