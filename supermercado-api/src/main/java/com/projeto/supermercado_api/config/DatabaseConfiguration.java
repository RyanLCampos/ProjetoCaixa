package com.projeto.supermercado_api.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {

    @Value("${spring.datasource.url}")
    String url;

    @Value("${spring.datasource.username}")
    String username;

    @Value("${spring.datasource.password}")
    String password;

    @Value("${spring.datasource.driver-class-name}")
    String driver;

    @Bean
    DataSource hikariDataSource(){
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        config.setDriverClassName(driver);

        config.setMaximumPoolSize(30);
        config.setMinimumIdle(5);
        config.setIdleTimeout(300000); // (5 min)
        config.setMaxLifetime(1800000); // (30 min)
        config.setConnectionTimeout(30000); // (30s)
        config.setValidationTimeout(5000); // (5s)
        config.setLeakDetectionThreshold(20000); // (20s)
        config.setPoolName("supermercado-db-pool");
        config.setConnectionTestQuery("select 1");

        return new HikariDataSource(config);
    }

}
