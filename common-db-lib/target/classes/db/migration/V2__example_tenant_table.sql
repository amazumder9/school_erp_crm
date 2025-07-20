-- Example tenant-specific table for schema-per-tenant
CREATE TABLE IF NOT EXISTS tenant_example (
    id BIGSERIAL PRIMARY KEY,
    tenant_id VARCHAR(64) NOT NULL,
    data VARCHAR(255),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);
