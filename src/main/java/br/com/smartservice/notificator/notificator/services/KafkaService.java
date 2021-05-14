package br.com.smartservice.notificator.notificator.services;

import br.com.smartservice.notificator.notificator.dtos.internal.PushNotificationTopicMessageDto;
import br.com.smartservice.notificator.notificator.dtos.kafka.KafkaBaseDto;
import br.com.smartservice.notificator.notificator.dtos.kafka.NotificatorConsumerDto;
import br.com.smartservice.notificator.notificator.models.NotificationSent;
import br.com.smartservice.notificator.notificator.repositories.NotificationsSentRepository;
import br.com.smartservice.notificator.notificator.utils.JsonUtils;
import br.com.smartservice.notificator.notificator.utils.kafka.KafkaTopics;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Slf4j
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class KafkaService {

    private final PushNotificationService pushNotificationService;
    private final NotificationsSentRepository notificationsSentRepository;
    private final String TOPIC_PUSH_NOTIFICATION = "INCIDENTS";

    @KafkaListener(topics = KafkaTopics.NOTIFICATION_TOPIC)
    @Transactional
    public void consume(KafkaBaseDto consumerRecord) throws JsonProcessingException {
        log.info("Object received: {}", consumerRecord.toString());
        NotificatorConsumerDto payload = consumerRecord.getPayload();
        if (Objects.nonNull(payload)) {
            String content = JsonUtils.toJson(payload);
            pushNotificationService.sendMessageWithTopic(new PushNotificationTopicMessageDto("INCIDENTS", content, TOPIC_PUSH_NOTIFICATION));
            notificationsSentRepository.save(new NotificationSent(content));
        }
    }
}
