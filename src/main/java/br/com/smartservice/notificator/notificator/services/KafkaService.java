package br.com.smartservice.notificator.notificator.services;

import br.com.smartservice.notificator.notificator.utils.kafka.KafkaTopics;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaService {
    @KafkaListener(topics = KafkaTopics.INCIDENT_TOPIC)
    public void consume(Object object)
    {
        log.info("Object received {}", object.toString());
    }
}
