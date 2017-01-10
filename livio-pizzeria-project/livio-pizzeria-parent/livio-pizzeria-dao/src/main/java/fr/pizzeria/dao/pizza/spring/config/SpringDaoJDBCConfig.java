
package fr.pizzeria.dao.pizza.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("fr.pizzeria.dao")
@EnableTransactionManagement
@EnableJpaRepositories("fr.pizzeria.dao.repos")
@EnableAspectJAutoProxy
public class SpringDaoJDBCConfig {
	//
	// @Bean
	// public DataSource getDataSource() {
	// DriverManagerDataSource dataSource = new DriverManagerDataSource();
	// dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	// dataSource.setUrl("jdbc:mysql://localhost:3306/pizzeria4?useSSL=false");
	// dataSource.setUsername("root");
	// dataSource.setPassword("");
	// return dataSource;
	// }

	// @Bean
	// public DataSource getDataSource() {
	// EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
	// EmbeddedDatabase db =
	// builder.setType(EmbeddedDatabaseType.H2).addScript("pizzeria4.sql").build();
	// return db;
	// }

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager();
	}

	@Bean
	public PersistenceAnnotationBeanPostProcessor beanPostProcessor() {
		return new PersistenceAnnotationBeanPostProcessor();
	}

	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		LocalEntityManagerFactoryBean entityManagerFactoryBean = new LocalEntityManagerFactoryBean();
		entityManagerFactoryBean.setPersistenceUnitName("livio-pizzeria");
		return entityManagerFactoryBean;
	}
}