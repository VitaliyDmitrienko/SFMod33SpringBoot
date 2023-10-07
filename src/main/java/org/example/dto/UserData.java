package org.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.Serializable;

@Data
public class UserData implements Serializable {
    @Autowired
    @Qualifier("userData")
    private UserData userData;

    @JsonProperty("id")
    private int userID;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

}
