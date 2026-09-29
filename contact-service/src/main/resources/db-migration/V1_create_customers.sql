CREATE TABLE customers (
    id CHAR(36) PRIMARY KEY,
    customer_number VARCHAR(50) NOT NULL UNIQUE,

    first_name VARCHAR(100) NOT NULL,
    middle_name VARCHAR(100),
    last_name VARCHAR(100),

    date_of_birth DATE,
    gender VARCHAR(30),

    status VARCHAR(30) NOT NULL,
    source VARCHAR(50),

    owner_id CHAR(36),

    created_at TIMESTAMP(6) NOT NULL,
    updated_at TIMESTAMP(6) NOT NULL,
    created_by CHAR(36),
    updated_by CHAR(36),

    INDEX idx_customer_owner (owner_id),
    INDEX idx_customer_status (status),
    INDEX idx_customer_name (last_name, first_name),
    INDEX idx_customer_source (source)
);