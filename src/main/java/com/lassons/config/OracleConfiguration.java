package com.lassons.config;

import oracle.jdbc.pool.OracleDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.validation.constraints.NotNull;
import java.sql.SQLException;

/**
 * Created by pjkant on 1/10/16.
 */

@Configuration
@EntityScan

public class OracleConfiguration {
	@NotNull
	@Value("${oracle.username}")
	private String username;

	@NotNull
	@Value("${oracle.password}")
	private String password;

	@NotNull
	@Value("${oracle.url}")
	private String url;


	@Bean
	DataSource dataSource() throws SQLException {

		OracleDataSource dataSource = new OracleDataSource();
		dataSource.setUser(username);
		dataSource.setPassword(password);
		dataSource.setURL(url);
		dataSource.setImplicitCachingEnabled(true);
		dataSource.setFastConnectionFailoverEnabled(true);
		return dataSource;
	}
}

