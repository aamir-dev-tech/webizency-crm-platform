package com.webizency.crm.user_service.repository;

import com.webizency.crm.user_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByKeycloakUserId(
            String keycloakUserId);

    Optional<User> findByEmailIgnoreCase(
            String email);

    boolean existsByEmailIgnoreCase(
            String email);

}
