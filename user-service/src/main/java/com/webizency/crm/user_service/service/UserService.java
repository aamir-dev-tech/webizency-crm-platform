package com.webizency.crm.user_service.service;

import com.webizency.crm.user_service.dto.CreateUserRequest;
import com.webizency.crm.user_service.dto.UserResponse;
import com.webizency.crm.user_service.entity.User;
import com.webizency.crm.user_service.entity.UserStatus;
import com.webizency.crm.user_service.exception.DuplicateResourceException;
import com.webizency.crm.user_service.mapper.UserMapper;
import com.webizency.crm.user_service.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

@Service
@Transactional
public class UserService {

    private static final Logger log =
            LoggerFactory.getLogger(UserService.class);

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

        log.info(
                "Creating CRM user: email={}, employeeCode={}",
                request.email(),
                request.employeeCode()
        );

        if (userRepository.existsByKeycloakUserId(request.keycloakUserId())) {
            throw new DuplicateResourceException(
                    "A CRM user already exists for this Keycloak user"
            );
        }

        if (userRepository.existsByEmailIgnoreCase(request.email())) {
            throw new DuplicateResourceException(
                    "A user already exists with email: " + request.email()
            );
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
