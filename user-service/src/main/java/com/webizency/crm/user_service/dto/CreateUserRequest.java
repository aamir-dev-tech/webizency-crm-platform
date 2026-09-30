package com.webizency.crm.user_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateUserRequest(@NotBlank
                                String keycloakUserId,

                                @Size(max = 50)
                                String employeeCode,

                                @NotBlank
                                @Size(max = 100)
                                String firstName,

                                @Size(max = 100)
                                String lastName,

                                @NotBlank
                                @Email
                                String email,

                                @Size(max = 30)
                                String phone,

                                String managerId) {
}
