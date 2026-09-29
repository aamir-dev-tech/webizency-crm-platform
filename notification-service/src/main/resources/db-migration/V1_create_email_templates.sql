CREATE TABLE email_templates (
    id CHAR(36) PRIMARY KEY,

    template_code VARCHAR(100) NOT NULL UNIQUE,

    subject_template VARCHAR(255) NOT NULL,
    body_template TEXT NOT NULL,

    status VARCHAR(30) NOT NULL,

    created_at TIMESTAMP(6) NOT NULL,
    updated_at TIMESTAMP(6) NOT NULL
);