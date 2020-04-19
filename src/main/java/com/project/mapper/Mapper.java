package com.project.mapper;

import com.project.model.dao.CustomerDAO;
import com.project.model.dto.CustomerDTO;

public interface Mapper {

    CustomerDAO convertDtoToDao(CustomerDTO customerDTO, int id);
}
