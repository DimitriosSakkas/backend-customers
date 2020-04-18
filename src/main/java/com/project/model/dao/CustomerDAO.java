package com.project.model.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "customer")
@Data
public class CustomerDAO {

    @Id
    @Column(name = "customer_id")
    private int id;
    @JsonProperty("username")
    private String userName;
    @JsonProperty("firstname")
    private String firstName;
    @JsonProperty("lastname")
    private String lastName;
    @JsonProperty("dateofbirht")
    private Date dateOfBirth;
    private String password;
}
