CREATE TABLE email_logs (
    id CHAR(36) PRIMARY KEY,

    event_id CHAR(36),

    customer_id CHAR(36),
    lead_id CHAR(36),

    recipient_email VARCHAR(255) NOT NULL,

    template_code VARCHAR(100),

    subject VARCHAR(255),

    status VARCHAR(30) NOT NULL,

    provider_message_id VARCHAR(255),

    sent_at TIMESTAMP(6),
    failed_at TIMESTAMP(6),

    retry_count INT NOT NULL DEFAULT 0,

    error_message TEXT,

    created_at TIMESTAMP(6) NOT NULL,

    INDEX idx_email_logs_customer (customer_id),
    INDEX idx_email_logs_lead (lead_id),
    INDEX idx_email_logs_status (status),
    INDEX idx_email_logs_created_at (created_at)
);