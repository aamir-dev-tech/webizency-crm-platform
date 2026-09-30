package com.webizency.crm.user_service.service;

import com.webizency.crm.user_service.dto.CreateUserRequest;
import com.webizency.crm.user_service.dto.UserResponse;
import com.webizency.crm.user_service.entity.User;
import com.webizency.crm.user_service.entity.UserStatus;
import com.webizency.crm.user_service.mapper.UserMapper;
import com.webizency.crm.user_service.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(
            UserRepository userRepository,
            UserMapper userMapper) {

        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponse createUser(
            CreateUserRequest request,
            String currentUserId) {

        if (userRepository
                .existsByEmailIgnoreCase(request.email())) {

            throw new IllegalArgumentException(
                    "User with email already exists");
        }

        Instant now = Instant.now();

        User user = new User();

        user.setId(UUID.randomUUID().toString());
        user.setKeycloakUserId(request.keycloakUserId());
        user.setEmployeeCode(request.employeeCode());
        user.setFirstName(request.firstName());
        user.setLastName(request.lastName());
        user.setEmail(request.email());
        user.setPhone(request.phone());
        user.setManagerId(request.managerId());
        user.setStatus(UserStatus.ACTIVE);

        user.setCreatedAt(now);
        user.setUpdatedAt(now);
        user.setCreatedBy(currentUserId);
        user.setUpdatedBy(currentUserId);

        User saved = userRepository.save(user);

        return userMapper.toResponse(saved);
    }

    @Transactional(readOnly = true)
    public UserResponse getUser(String id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "User not found: " + id));

        return userMapper.toResponse(user);
    }
}
