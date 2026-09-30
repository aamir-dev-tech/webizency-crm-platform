CREATE TABLE teams (
    id CHAR(36) PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    description VARCHAR(500),
    manager_id CHAR(36),
    status VARCHAR(30) NOT NULL,
    created_at TIMESTAMP(6) NOT NULL,
    updated_at TIMESTAMP(6) NOT NULL,
    created_by CHAR(36),
    updated_by CHAR(36),

    INDEX idx_teams_manager (manager_id),
    INDEX idx_teams_status (status)
);