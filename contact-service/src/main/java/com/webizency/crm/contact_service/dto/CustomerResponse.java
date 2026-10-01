package com.webizency.crm.contact_service.dto;

import com.webizency.crm.contact_service.entity.CustomerStatus;

import java.time.Instant;
import java.time.LocalDate;

public record CustomerResponse(String id,

                               String customerNumber,

                               String firstName,

                               String middleName,

                               String lastName,

                               LocalDate dateOfBirth,

                               String gender,

                               CustomerStatus status,

                               String source,

                               String ownerId,

                               Instant createdAt,

                               Instant updatedAt) {
}
