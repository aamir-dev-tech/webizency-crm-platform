CREATE TABLE lead_assignments (
    id CHAR(36) PRIMARY KEY,

    lead_id CHAR(36) NOT NULL,

    from_user_id CHAR(36),
    to_user_id CHAR(36) NOT NULL,

    assigned_by CHAR(36),
    assigned_at TIMESTAMP(6) NOT NULL,

    reason VARCHAR(500),

    INDEX idx_lead_assignments_lead (lead_id),
    INDEX idx_lead_assignments_user (to_user_id),
    INDEX idx_lead_assignments_date (assigned_at)
);