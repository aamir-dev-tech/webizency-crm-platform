CREATE TABLE customers (
                           id CHAR(36) NOT NULL,

                           customer_number VARCHAR(50) NOT NULL,

                           first_name VARCHAR(100) NOT NULL,
                           middle_name VARCHAR(100),
                           last_name VARCHAR(100),

                           date_of_birth DATE,
                           gender VARCHAR(30),

                           status VARCHAR(30) NOT NULL,

                           source VARCHAR(50),

                           owner_id CHAR(36),

                           created_at TIMESTAMP(6) NOT NULL,
                           updated_at TIMESTAMP(6) NOT NULL,

                           created_by CHAR(36),
                           updated_by CHAR(36),

                           PRIMARY KEY (id),

                           CONSTRAINT uk_customers_number
                               UNIQUE (customer_number),

                           INDEX idx_customers_owner (owner_id),
                           INDEX idx_customers_status (status),
                           INDEX idx_customers_source (source),
                           INDEX idx_customers_name (last_name, first_name)
);