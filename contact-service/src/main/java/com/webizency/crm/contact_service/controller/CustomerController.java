package com.webizency.crm.contact_service.controller;

import com.webizency.crm.contact_service.dto.CreateCustomerRequest;
import com.webizency.crm.contact_service.dto.CustomerResponse;
import com.webizency.crm.contact_service.service.CustomerService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(
            CustomerService customerService) {

        this.customerService = customerService;
    }

    @PostMapping
    @PreAuthorize("""
        hasAnyRole(
            'ADMIN',
            'SALES_MANAGER',
            'SALES_EXECUTIVE'
        )
    """)
    public ResponseEntity<CustomerResponse> createCustomer(
            @Valid @RequestBody CreateCustomerRequest request) {

        CustomerResponse response =
                customerService.createCustomer(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{id}")
    @PreAuthorize("""
        hasAnyRole(
            'ADMIN',
            'SALES_MANAGER',
            'SALES_EXECUTIVE',
            'VIEWER'
        )
    """)
    public ResponseEntity<CustomerResponse> getCustomer(
            @PathVariable String id) {

        return ResponseEntity.ok(
                customerService.getCustomer(id)
        );
    }
}