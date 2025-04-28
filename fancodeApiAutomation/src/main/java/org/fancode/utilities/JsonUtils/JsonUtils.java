package org.fancode.utilities.JsonUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.SerializationException;

import java.io.IOException;

public class JsonUtils {

    public static ObjectMapper objectMapper;

    public JsonUtils(){
        objectMapper = new ObjectMapper();
    }

    public String toJson(Object object) throws IOException {
        try {
            return objectMapper.writeValueAsString(object);
        }catch (SerializationException e){
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T fromJson(String json, TypeReference<T> typeRef) throws JsonProcessingException {
        return objectMapper.readValue(json, typeRef);
    }
}
