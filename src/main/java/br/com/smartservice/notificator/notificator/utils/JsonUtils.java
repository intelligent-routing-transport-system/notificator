package br.com.smartservice.notificator.notificator.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
    private final static ObjectMapper objectMapper = new ObjectMapper();

    public static <T> String toJson(T object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }
}
