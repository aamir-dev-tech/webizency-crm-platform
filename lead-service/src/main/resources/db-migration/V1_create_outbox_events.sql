CREATE TABLE outbox_events (
    id CHAR(36) PRIMARY KEY,

    aggregate_type VARCHAR(100) NOT NULL,
    aggregate_id CHAR(36) NOT NULL,

    event_type VARCHAR(100) NOT NULL,
    event_version INT NOT NULL,

    payload JSON NOT NULL,

    status VARCHAR(30) NOT NULL DEFAULT 'PENDING',

    created_at TIMESTAMP(6) NOT NULL,
    published_at TIMESTAMP(6),

    retry_count INT NOT NULL DEFAULT 0,
    last_error TEXT,

    INDEX idx_outbox_status_created (status, created_at),
    INDEX idx_outbox_aggregate (aggregate_type, aggregate_id)
);