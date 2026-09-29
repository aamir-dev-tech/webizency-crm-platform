CREATE TABLE leads (
    id CHAR(36) PRIMARY KEY,
    lead_number VARCHAR(50) NOT NULL UNIQUE,

    customer_id CHAR(36) NOT NULL,

    source VARCHAR(50),
    status VARCHAR(30) NOT NULL,
    stage VARCHAR(30) NOT NULL,

    assigned_to CHAR(36),

    interested_product VARCHAR(255),
    expected_value DECIMAL(15,2),
    currency VARCHAR(3),

    description TEXT,

    created_at TIMESTAMP(6) NOT NULL,
    updated_at TIMESTAMP(6) NOT NULL,
    created_by CHAR(36),
    updated_by CHAR(36),

    INDEX idx_leads_customer (customer_id),
    INDEX idx_leads_assigned_to (assigned_to),
    INDEX idx_leads_stage (stage),
    INDEX idx_leads_status (status),
    INDEX idx_leads_source (source),
    INDEX idx_leads_created_at (created_at)
);