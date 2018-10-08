package com.arunveersingh.springdata;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * This class demonstrates the Java Configuration way of configuring Spring Data - with JPA.
 * This spring-data-learning project may demonstrates other ways of configuring Spring Data, so don't get confused by that. 
 * I am putting in this comment for me :) :)
 * @author arunveersingh9@gmail.com
 *
 */
@Configuration
@EnableJpaRepositories("com.arunveersingh.springdata")
@EnableTransactionManagement
@ComponentScan("com.arunveersingh.springdata")
public class DataConfiguration {
	
	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		return builder.setType(EmbeddedDatabaseType.H2).build();
	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		
		Properties props = new Properties();
		props.put("hibernate.hbm2ddl.auto", "create-drop");
		props.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
		
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource());
		factory.setPackagesToScan("com.arunveersingh.springdata");
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setJpaProperties(props);
		factory.afterPropertiesSet();
		
		return factory.getObject();
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}

}
