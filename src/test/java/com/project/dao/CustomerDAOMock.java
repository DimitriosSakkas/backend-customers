package com.project.dao;

import com.project.model.dao.CustomerDAO;
import java.util.Date;

public class CustomerDAOMock {

    private CustomerDAO dao;
    public final static int id = 1;
    public final static String userName = "username";
    public final static String firstName = "firstname";
    public final static String lastName = "lastname";
    public final static Date dateOfBirth = new Date();
    public final static String password = "password";

    public CustomerDAOMock() {
        dao = new CustomerDAO();
        dao.setId(id);
        dao.setDateOfBirth(dateOfBirth);
        dao.setLastName(lastName);
        dao.setFirstName(firstName);
        dao.setPassword(password);
        dao.setUserName(userName);
    }

    public CustomerDAO getCustomerDAO() {
        return dao;
    }
}
