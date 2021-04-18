package br.com.smartservice.notificator.notificator.services;

import br.com.smartservice.notificator.notificator.utils.kafka.KafkaTopics;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaService {
    @KafkaListener(topics = KafkaTopics.NOTIFICATION_TOPIC)
    public void consume(ConsumerRecord<String, Object> consumerRecord)
    {
        log.info("Object received {}", consumerRecord.toString());
    }
}
