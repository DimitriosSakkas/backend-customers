package com.project.model.dto;

import com.sun.istack.NotNull;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    @NotBlank(message = "Please provide a userName")
    private String userName;
    @NotBlank(message = "Please provide a password")
    private String password;
    @NotBlank(message = "Please provide a firstName")
    private String firstName;
    @NotBlank(message = "Please provide a lastName")
    private String lastName;
    @NotNull
    private Date dateOfBirth;

}
