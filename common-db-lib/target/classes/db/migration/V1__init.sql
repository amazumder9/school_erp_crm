-- Example DDL for all microservices (add your entities here)
-- This file will be run by Flyway for each schema/tenant

CREATE TABLE IF NOT EXISTS example_entity (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);
