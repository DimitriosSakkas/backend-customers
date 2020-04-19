package com.project.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CredentialsDTO {

    @JsonProperty(required = true)
    private String userName;
    @JsonProperty(required = true)
    private String password;

}
