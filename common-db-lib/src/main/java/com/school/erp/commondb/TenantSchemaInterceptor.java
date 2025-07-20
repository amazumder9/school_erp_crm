package com.school.erp.commondb;

import org.hibernate.EmptyInterceptor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.Type;
import java.io.Serializable;

public class TenantSchemaInterceptor extends EmptyInterceptor {
    @Override
    public String onPrepareStatement(String sql) {
        String tenant = TenantContext.getTenant();
        if (tenant != null && !tenant.isEmpty()) {
            // Set schema for the current tenant
            return "SET search_path TO " + tenant + ";" + sql;
        }
        return sql;
    }
}
