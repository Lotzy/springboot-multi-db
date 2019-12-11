package org.lotzy.sample.multidb.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

/**
 * <pre>
 * Title: Db2Configurator class
 * Description: Second datasource configuration class
 * </pre>
 *
 * @author Lotzy (lotzy_l@yahoo.com)
 * @version 1.0
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "org.lotzy.sample.multidb.db2.dao" }, entityManagerFactoryRef = "db2EntityManagerFactory", transactionManagerRef = "db2transactionManager")
public class Db2Configurator {

	@Bean(name = "db2DataSourceProperties")
	@ConfigurationProperties("db2.datasource")
	public DataSourceProperties dataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean(name = "db2DataSource")
	@ConfigurationProperties("db2.datasource.configuration")
	public DataSource dataSource(@Qualifier("db2DataSourceProperties") DataSourceProperties db2DataSourceProperties) {
		return db2DataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}

	@Bean(name = "db2EntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("db2DataSource") DataSource db2DataSource) {
		return builder.dataSource(db2DataSource).packages("org.lotzy.sample.multidb.db2.entity").persistenceUnit("db2").build();
	}

	@Bean(name = "db2transactionManager")
	public PlatformTransactionManager db2transactionManager(@Qualifier("db2EntityManagerFactory") EntityManagerFactory db2EntityManagerFactory) {
		return new JpaTransactionManager(db2EntityManagerFactory);
	}
}
