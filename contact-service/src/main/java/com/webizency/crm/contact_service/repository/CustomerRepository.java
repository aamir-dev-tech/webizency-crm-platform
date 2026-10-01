package com.webizency.crm.contact_service.repository;

import com.webizency.crm.contact_service.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository
        extends JpaRepository<Customer, String> {

    Optional<Customer> findByCustomerNumber(
            String customerNumber
    );

    boolean existsByCustomerNumber(
            String customerNumber
    );
}