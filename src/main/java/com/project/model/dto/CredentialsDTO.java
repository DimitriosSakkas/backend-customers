package com.project.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CredentialsDTO {

    @NotBlank(message = "Please provide a userName")
    private String userName;
    @NotBlank(message = "Please provide a password")
    private String password;

}
