package com.project.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    @JsonProperty(required = true)
    private String userName;
    @JsonProperty(required = true)
    private String password;
    @JsonProperty(required = true)
    private String firstName;
    @JsonProperty(required = true)
    private String lastName;
    @JsonProperty(required = true)
    private Date dateOfBirth;

}
