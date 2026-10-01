CREATE TABLE customer_contacts (
    id CHAR(36) PRIMARY KEY,
    customer_id CHAR(36) NOT NULL,

    contact_type VARCHAR(30) NOT NULL,
    contact_value VARCHAR(255) NOT NULL,

    is_primary BOOLEAN NOT NULL DEFAULT FALSE,
    is_verified BOOLEAN NOT NULL DEFAULT FALSE,

    created_at TIMESTAMP(6) NOT NULL,
    updated_at TIMESTAMP(6) NOT NULL,

    INDEX idx_customer_contacts_customer (customer_id),
    INDEX idx_customer_contacts_type (contact_type),
    INDEX idx_customer_contacts_value (contact_value)
);