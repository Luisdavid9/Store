package com.example.Negocio.Configuration;

import com.example.Negocio.Configuration.domain.DataBaseCredentials;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

    @Bean
    @Profile({"test"})
    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:scripts/schema.sql")
              //  .addScript("classpath:scripts/data.sql")
                .build();
    }

    @Bean
    @Profile({"dev"})
    public DataSource hikariDatasource(DataBaseCredentials credentials) {
        HikariConfig config = new HikariConfig();
        config.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");
        config.addDataSourceProperty("databaseName", credentials.getDatabase());
        config.addDataSourceProperty("portNumber", credentials.getPort());
        config.addDataSourceProperty("serverName", credentials.getHost());
        config.setUsername(credentials.getUsername());
        config.setPassword(credentials.getPassword());
        return new HikariDataSource(config);
    }
}
