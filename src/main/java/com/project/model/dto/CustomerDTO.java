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

    @JsonProperty("username")
    private String userName;
    private String password;
    @JsonProperty("firstname")
    private String firstName;
    @JsonProperty("lastname")
    private String lastName;
    @JsonProperty("dateofbirth")
    private Date dateOfBirth;

}
