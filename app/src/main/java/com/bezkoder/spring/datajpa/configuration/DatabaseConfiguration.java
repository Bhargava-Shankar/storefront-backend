package com.bezkoder.spring.datajpa.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;


@Configuration
public class DatabaseConfiguration {



    @Value("${MYSQLDB_ROOT_URL}")
    private String databaseUrl;

    @Value("${MYSQLDB_USER}")
    private String username;

    @Value("${MYSQLDB_ROOT_PASSWORD}")
    private String password;

    @Bean
    public DataSource dataSourceCreation() {
        System.out.println("Database URL"+databaseUrl);
        System.out.println("Username :"+username);
        System.out.println("Password :"+password);
        HikariConfig hikariConfig = new HikariConfig();

            hikariConfig.setJdbcUrl(databaseUrl);
            hikariConfig.setUsername(username);
            hikariConfig.setPassword(password);
            hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");

        return new HikariDataSource(hikariConfig);

    }
}