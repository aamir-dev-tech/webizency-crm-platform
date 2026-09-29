CREATE TABLE lead_metrics (
    id CHAR(36) PRIMARY KEY,

    metric_date DATE NOT NULL,

    total_leads INT NOT NULL DEFAULT 0,
    new_leads INT NOT NULL DEFAULT 0,
    contacted_leads INT NOT NULL DEFAULT 0,
    qualified_leads INT NOT NULL DEFAULT 0,
    opportunities INT NOT NULL DEFAULT 0,
    proposals INT NOT NULL DEFAULT 0,
    negotiations INT NOT NULL DEFAULT 0,
    won_leads INT NOT NULL DEFAULT 0,
    lost_leads INT NOT NULL DEFAULT 0,

    UNIQUE KEY uk_lead_metrics_date (metric_date)
);