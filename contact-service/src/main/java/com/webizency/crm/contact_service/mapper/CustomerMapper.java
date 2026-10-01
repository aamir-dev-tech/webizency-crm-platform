package com.webizency.crm.contact_service.mapper;

import com.webizency.crm.contact_service.dto.CustomerResponse;
import com.webizency.crm.contact_service.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerResponse toResponse(Customer customer) {

        return new CustomerResponse(
                customer.getId(),
                customer.getCustomerNumber(),
                customer.getFirstName(),
                customer.getMiddleName(),
                customer.getLastName(),
                customer.getDateOfBirth(),
                customer.getGender(),
                customer.getStatus(),
                customer.getSource(),
                customer.getOwnerId(),
                customer.getCreatedAt(),
                customer.getUpdatedAt()
        );
    }
}