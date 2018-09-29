package com.wtl.DAOService.Config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
		value = "com.wtl.DAOService.Config",
		entityManagerFactoryRef = "writeEntityManagerFactory",
		transactionManagerRef = "writeTransactionManager"
		)
public class WriteDataSourceConfig {
	
	@Autowired
	private JpaProperties jpaProperties;
	
	@Autowired
	@Qualifier("writeDruidDataSource")
	private DataSource writeDruidDataSource;
	
	@Bean(name = "writeEntityManagerFactory")
	@Primary
	public EntityManagerFactory writeEntityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("com.wtl.DAOService.Entity");
		factory.setDataSource(writeDruidDataSource);
		factory.setJpaPropertyMap(jpaProperties.getProperties());
		factory.afterPropertiesSet();
		return factory.getObject();
	}
	
	@Bean(name = "writeTransactionManager")
    @Primary
	public PlatformTransactionManager writeTransactionManager() {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(this.writeEntityManagerFactory());
		return jpaTransactionManager;
	}
	
}
