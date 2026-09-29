CREATE TABLE activity_metrics (
    id CHAR(36) PRIMARY KEY,

    metric_date DATE NOT NULL,

    total_activities INT NOT NULL DEFAULT 0,
    completed_activities INT NOT NULL DEFAULT 0,
    pending_activities INT NOT NULL DEFAULT 0,
    overdue_activities INT NOT NULL DEFAULT 0,

    UNIQUE KEY uk_activity_metrics_date (metric_date)
);