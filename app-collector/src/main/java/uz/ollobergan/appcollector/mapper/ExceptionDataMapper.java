package uz.ollobergan.appcollector.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import uz.ollobergan.appcollector.dto.ExceptionData;

public class ExceptionDataMapper {
    public static ExceptionData jsonToDto(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(json, ExceptionData.class);
    }
}
