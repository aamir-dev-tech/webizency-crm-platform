CREATE TABLE follow_ups (
    id CHAR(36) PRIMARY KEY,

    activity_id CHAR(36) NOT NULL,

    customer_id CHAR(36),
    lead_id CHAR(36),

    assigned_to CHAR(36) NOT NULL,

    due_at TIMESTAMP(6) NOT NULL,

    status VARCHAR(30) NOT NULL,

    reminder_sent BOOLEAN NOT NULL DEFAULT FALSE,

    completed_at TIMESTAMP(6),

    created_at TIMESTAMP(6) NOT NULL,
    updated_at TIMESTAMP(6) NOT NULL,

    INDEX idx_followup_due (due_at),
    INDEX idx_followup_assigned (assigned_to),
    INDEX idx_followup_status (status),
    INDEX idx_followup_lead (lead_id)
);