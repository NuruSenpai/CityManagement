package org.example.carserver.kafka;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TestKafkaConsumer {

    @KafkaListener(topics = "topic")
    public void test(String line) {
        System.out.println(line);
    }
}
