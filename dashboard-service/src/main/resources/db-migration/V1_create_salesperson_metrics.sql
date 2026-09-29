CREATE TABLE salesperson_metrics (
    id CHAR(36) PRIMARY KEY,

    metric_date DATE NOT NULL,
    user_id CHAR(36) NOT NULL,

    assigned_leads INT NOT NULL DEFAULT 0,
    qualified_leads INT NOT NULL DEFAULT 0,
    won_leads INT NOT NULL DEFAULT 0,
    lost_leads INT NOT NULL DEFAULT 0,

    pending_followups INT NOT NULL DEFAULT 0,
    completed_followups INT NOT NULL DEFAULT 0,

    UNIQUE KEY uk_salesperson_metric (
        metric_date,
        user_id
    ),

    INDEX idx_salesperson_metric_user (user_id)
);