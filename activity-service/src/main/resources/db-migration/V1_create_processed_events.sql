CREATE TABLE processed_events (
    event_id CHAR(36) NOT NULL,
    consumer_name VARCHAR(100) NOT NULL,

    processed_at TIMESTAMP(6) NOT NULL,

    PRIMARY KEY (event_id, consumer_name)
);