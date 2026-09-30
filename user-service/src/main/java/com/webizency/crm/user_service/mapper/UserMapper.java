package com.webizency.crm.user_service.mapper;

import com.webizency.crm.user_service.dto.UserResponse;
import com.webizency.crm.user_service.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponse toResponse(User user) {

        return new UserResponse(
                user.getId(),
                user.getKeycloakUserId(),
                user.getEmployeeCode(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhone(),
                user.getStatus().name(),
                user.getManagerId(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}
