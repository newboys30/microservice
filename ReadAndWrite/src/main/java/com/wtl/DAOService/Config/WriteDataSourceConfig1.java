package com.wtl.DAOService.Config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
		value = "com.wtl.DAOService.Config",
		entityManagerFactoryRef = "writeEntityManagerFactory",
		transactionManagerRef = "writeTransactionManager"
		)
public class WriteDataSourceConfig1 {
	
	@Autowired
	private JpaProperties jpaProperties;
	
	@Autowired
	@Qualifier("writeDruidDataSource")
	private DataSource writeDruidDataSource;
	
	@Bean(name = "writeEntityManagerFactoryBean")
	@Primary
	public LocalContainerEntityManagerFactoryBean writeEntityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(writeDruidDataSource)
				.properties(jpaProperties.getProperties())
				.packages("com.wtl.DAOService.Entity")
				.persistenceUnit("writePersistenceUnit")
				.build();
	}
	
	@Bean(name = "writeEntityManagerFactory")
    @Primary
	public EntityManagerFactory writeEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		return this.writeEntityManagerFactoryBean(builder).getObject();
	}
	
	@Bean(name = "writeTransactionManager")
	@Primary
	public PlatformTransactionManager writeTransactionManager(EntityManagerFactoryBuilder builder) {
	return new JpaTransactionManager(writeEntityManagerFactory(builder));
	}
	
}
