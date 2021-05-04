package br.com.smartservice.notificator.notificator.configurations;

import br.com.smartservice.notificator.notificator.dtos.kafka.KafkaBaseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.kafka.common.serialization.Deserializer;

public class NotificatorCustomDeserializer implements Deserializer {
    private final ObjectMapper objectMapper = new ObjectMapper();


    @Override
    @SneakyThrows
    public KafkaBaseDto deserialize(String key, byte[] valueInBytes) {
        return objectMapper.readValue(valueInBytes, KafkaBaseDto.class);
    }
}
