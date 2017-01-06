// package fr.pizzeria.dao.pizza.spring;
//
// import javax.sql.DataSource;
//
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.ComponentScan;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
// import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
// import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
//
// @Configuration
// @ComponentScan("fr.pizzeria")
// public class SpringJDBCConfig {
//
// // @Bean
// // public DataSource getDataSrouce() {
// // DriverManagerDataSource dataSource = new DriverManagerDataSource();
// //
// // dataSource.setDriverClassName("com.mysql.jdbc.Driver");
// //
// // dataSource.setUrl("jdbc:mysql://localhost:3306/pizzeria4?useSSL=false");
// //
// // dataSource.setUsername("root");
// //
// // dataSource.setPassword("");
// // return dataSource;
// // }
//
// @Bean
// public DataSource getDataSource() {
// EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
// EmbeddedDatabase db =
// builder.setType(EmbeddedDatabaseType.H2).addScript("pizzeria4.sql").build();
// return db;
// }
//
// }