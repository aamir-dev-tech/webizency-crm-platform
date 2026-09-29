CREATE TABLE activities (
    id CHAR(36) PRIMARY KEY,

    customer_id CHAR(36),
    lead_id CHAR(36),

    assigned_to CHAR(36),

    activity_type VARCHAR(30) NOT NULL,

    subject VARCHAR(255) NOT NULL,
    description TEXT,

    status VARCHAR(30) NOT NULL,

    scheduled_at TIMESTAMP(6),
    completed_at TIMESTAMP(6),

    created_at TIMESTAMP(6) NOT NULL,
    updated_at TIMESTAMP(6) NOT NULL,
    created_by CHAR(36),
    updated_by CHAR(36),

    INDEX idx_activity_customer (customer_id),
    INDEX idx_activity_lead (lead_id),
    INDEX idx_activity_assigned_to (assigned_to),
    INDEX idx_activity_status (status),
    INDEX idx_activity_scheduled_at (scheduled_at)
);