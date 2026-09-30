CREATE TABLE users (
    id CHAR(36) PRIMARY KEY,
    keycloak_user_id CHAR(36) NOT NULL UNIQUE,
    employee_code VARCHAR(50) UNIQUE,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100),
    email VARCHAR(255) NOT NULL UNIQUE,
    phone VARCHAR(30),
    status VARCHAR(30) NOT NULL,
    manager_id CHAR(36),
    created_at TIMESTAMP(6) NOT NULL,
    updated_at TIMESTAMP(6) NOT NULL,
    created_by CHAR(36),
    updated_by CHAR(36),

    INDEX idx_users_manager (manager_id),
    INDEX idx_users_status (status)
);