package com.project.model.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;

}
