package com.project.base.definition;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {


    private Integer status;

    private String type;

    private String title;

    private String detail;

    @JsonIgnore
    private String vin;

}
