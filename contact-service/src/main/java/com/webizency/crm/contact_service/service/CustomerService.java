package com.webizency.crm.contact_service.service;

import com.webizency.crm.contact_service.dto.CreateCustomerRequest;
import com.webizency.crm.contact_service.dto.CustomerResponse;
import com.webizency.crm.contact_service.entity.Customer;
import com.webizency.crm.contact_service.entity.CustomerStatus;
import com.webizency.crm.contact_service.exception.DuplicateResourceException;
import com.webizency.crm.contact_service.exception.ResourceNotFoundException;
import com.webizency.crm.contact_service.mapper.CustomerMapper;
import com.webizency.crm.contact_service.repository.CustomerRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(
            CustomerRepository customerRepository,
            CustomerMapper customerMapper) {

        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Transactional
    public CustomerResponse createCustomer(
            CreateCustomerRequest request) {

        Customer customer = new Customer();

        customer.setId(UUID.randomUUID().toString());

        customer.setCustomerNumber(
                generateCustomerNumber()
        );

        customer.setFirstName(request.firstName());
        customer.setMiddleName(request.middleName());
        customer.setLastName(request.lastName());
        customer.setDateOfBirth(request.dateOfBirth());
        customer.setGender(request.gender());
        customer.setSource(request.source());
        customer.setOwnerId(request.ownerId());

        customer.setStatus(CustomerStatus.ACTIVE);

        Instant now = Instant.now();

        customer.setCreatedAt(now);
        customer.setUpdatedAt(now);

        Customer savedCustomer =
                customerRepository.save(customer);

        return customerMapper.toResponse(savedCustomer);
    }

    @Transactional(readOnly = true)
    public CustomerResponse getCustomer(String id) {

        Customer customer = customerRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Customer not found: " + id
                        )
                );

        return customerMapper.toResponse(customer);
    }

    private String generateCustomerNumber() {

        String customerNumber;

        do {
            customerNumber =
                    "CUS-" +
                            UUID.randomUUID()
                                    .toString()
                                    .substring(0, 8)
                                    .toUpperCase();

        } while (
                customerRepository
                        .existsByCustomerNumber(customerNumber)
        );

        return customerNumber;
    }
}