CREATE TABLE lead_stage_history (
    id CHAR(36) PRIMARY KEY,

    lead_id CHAR(36) NOT NULL,

    from_stage VARCHAR(30),
    to_stage VARCHAR(30) NOT NULL,

    changed_by CHAR(36),
    changed_at TIMESTAMP(6) NOT NULL,

    reason VARCHAR(500),

    INDEX idx_stage_history_lead (lead_id),
    INDEX idx_stage_history_changed_at (changed_at)
);