package com.school.erp.commondb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.flyway.FlywayProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableConfigurationProperties(FlywayProperties.class)
public class SchemaPerTenantDataSourceConfig {

    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.username}")
    private String dbUser;
    @Value("${spring.datasource.password}")
    private String dbPassword;
    @Value("${spring.datasource.driver-class-name}")
    private String dbDriver;

    @Bean
    public DataSource dataSource() {
        // This DataSource will route based on the current tenant (schema)
        TenantAwareRoutingDataSource routingDataSource = new TenantAwareRoutingDataSource();
        // Default target datasource (for bootstrapping, fallback, or admin)
        DriverManagerDataSource defaultDataSource = new DriverManagerDataSource();
        defaultDataSource.setUrl(dbUrl);
        defaultDataSource.setUsername(dbUser);
        defaultDataSource.setPassword(dbPassword);
        defaultDataSource.setDriverClassName(dbDriver);

        // Map of tenantId/schema to DataSource (can be extended to cache per-tenant DataSources)
        Map<Object, Object> targetDataSources = new HashMap<>();
        // Optionally, pre-populate with known tenants or leave empty for dynamic
        // Example: targetDataSources.put("tenant1", createDataSourceForTenant("tenant1"));

        routingDataSource.setDefaultTargetDataSource(defaultDataSource);
        routingDataSource.setTargetDataSources(targetDataSources);
        routingDataSource.afterPropertiesSet();
        return routingDataSource;
    }

    // Helper to create a DataSource for a given tenant/schema (if you want to cache per-tenant DataSources)
    public DataSource createDataSourceForTenant(String schema) {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl(dbUrl);
        ds.setUsername(dbUser);
        ds.setPassword(dbPassword);
        ds.setDriverClassName(dbDriver);
        // Optionally, set schema here if needed
        return ds;
    }
}
