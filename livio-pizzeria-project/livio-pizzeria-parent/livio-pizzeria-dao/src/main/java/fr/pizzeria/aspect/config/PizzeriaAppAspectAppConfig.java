package fr.pizzeria.aspect.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("fr.pizzeria.aspect.service")
public class PizzeriaAppAspectAppConfig {

}
