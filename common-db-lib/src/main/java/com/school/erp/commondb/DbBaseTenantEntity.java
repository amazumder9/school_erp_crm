package com.school.erp.commondb;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class DbBaseTenantEntity extends DbBaseEntity {
    @Column(name = "tenant_id", nullable = false)
    private String tenantId;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}
