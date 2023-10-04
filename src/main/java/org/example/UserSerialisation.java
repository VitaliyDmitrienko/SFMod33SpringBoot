package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.UserData;

public class UserSerialisation {

    public static void JsonSerialisatoin () throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        UserData userData = new UserData();
        System.out.println(objectMapper.writeValueAsString(userData));
    }

    public static UserData JsonDeserialisation () {
        UserData userData = new UserData();
        return userData;
    }
}
