CREATE TABLE customer_preferences (
    id CHAR(36) PRIMARY KEY,
    customer_id CHAR(36) NOT NULL UNIQUE,

    email_opt_in BOOLEAN NOT NULL DEFAULT TRUE,
    sms_opt_in BOOLEAN NOT NULL DEFAULT TRUE,
    phone_opt_in BOOLEAN NOT NULL DEFAULT TRUE,

    preferred_contact_method VARCHAR(30),

    created_at TIMESTAMP(6) NOT NULL,
    updated_at TIMESTAMP(6) NOT NULL
);