CREATE TABLE user_roles (
    user_id CHAR(36) NOT NULL,
    role_id CHAR(36) NOT NULL,

    PRIMARY KEY (user_id, role_id),

    INDEX idx_user_roles_role (role_id)
);