CREATE TABLE customer_addresses (
    id CHAR(36) PRIMARY KEY,
    customer_id CHAR(36) NOT NULL,

    address_type VARCHAR(30) NOT NULL,

    address_line_1 VARCHAR(255),
    address_line_2 VARCHAR(255),
    city VARCHAR(100),
    state VARCHAR(100),
    postal_code VARCHAR(20),
    country VARCHAR(100),

    is_primary BOOLEAN NOT NULL DEFAULT FALSE,

    created_at TIMESTAMP(6) NOT NULL,
    updated_at TIMESTAMP(6) NOT NULL,

    INDEX idx_customer_addresses_customer (customer_id)
);