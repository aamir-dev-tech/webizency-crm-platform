package com.webizency.crm.contact_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CreateCustomerRequest(@NotBlank
                                    @Size(max = 100)
                                    String firstName,

                                    @Size(max = 100)
                                    String middleName,

                                    @Size(max = 100)
                                    String lastName,

                                    LocalDate dateOfBirth,

                                    @Size(max = 30)
                                    String gender,

                                    @Size(max = 50)
                                    String source,

                                    String ownerId) {
}
