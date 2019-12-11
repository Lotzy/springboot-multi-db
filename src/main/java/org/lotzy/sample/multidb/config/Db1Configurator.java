package org.lotzy.sample.multidb.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

/**
 * <pre>
 * Title: Db1Configurator class
 * Description: First Datasource configuration class
 * </pre>
 *
 * @author Lotzy
 * @version 1.0
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "org.lotzy.sample.multidb.db1.dao" }, entityManagerFactoryRef = "db1EntityManagerFactory", transactionManagerRef = "db1transactionManager")
public class Db1Configurator {

	@Primary
	@Bean(name = "db1DataSourceProperties")
	@ConfigurationProperties("db1.datasource")
	public DataSourceProperties dataSourceProperties() {
		return new DataSourceProperties();
	}

	@Primary
	@Bean(name = "db1DataSource")
	@ConfigurationProperties("db1.datasource.configuration")
	public DataSource dataSource(@Qualifier("db1DataSourceProperties") DataSourceProperties db1DataSourceProperties) {
		return db1DataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}

	@Primary
	@Bean(name = "db1EntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("db1DataSource") DataSource db1DataSource) {
		return builder.dataSource(db1DataSource).packages("org.lotzy.sample.multidb.db1.entity").persistenceUnit("db1").build();
	}

	@Primary
	@Bean(name = "db1transactionManager")
	public PlatformTransactionManager db1transactionManager(@Qualifier("db1EntityManagerFactory") EntityManagerFactory db1EntityManagerFactory) {
		return new JpaTransactionManager(db1EntityManagerFactory);
	}
}
