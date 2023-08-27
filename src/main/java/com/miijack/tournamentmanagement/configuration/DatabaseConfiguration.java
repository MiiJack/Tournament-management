package com.miijack.tournamentmanagement.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DatabaseConfiguration {
    @Bean
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost/tournamentdb",
                System.getenv("DB_USER"),
                System.getenv("DB_PASSWORD")
        );
    }
}
