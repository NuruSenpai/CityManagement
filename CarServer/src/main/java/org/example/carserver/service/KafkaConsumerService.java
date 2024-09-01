package org.example.carserver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class KafkaConsumerService {

    private final CarServiceImpl carService;

    @KafkaListener(topics = "person-deleted", groupId = "car-service")
    public void listen(Long personId) {
        System.out.println("Received personId: " + personId);
        carService.deleteAllOfPersonCars(personId);
    }
}
