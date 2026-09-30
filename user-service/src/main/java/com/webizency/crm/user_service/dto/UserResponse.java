package com.webizency.crm.user_service.dto;

import java.time.Instant;

public record UserResponse(String id,
                           String keycloakUserId,
                           String employeeCode,
                           String firstName,
                           String lastName,
                           String email,
                           String phone,
                           String status,
                           String managerId,
                           Instant createdAt,
                           Instant updatedAt) {
}
