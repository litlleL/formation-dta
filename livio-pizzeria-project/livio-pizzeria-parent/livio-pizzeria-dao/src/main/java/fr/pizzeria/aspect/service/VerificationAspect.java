package fr.pizzeria.aspect.service;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;

import fr.pizzeria.model.Pizza;

public class VerificationAspect {

	private Log log = LogFactory.getLog(this.getClass());

	@Before("execution(* fr.pizzeria.*.save(..)")
	public void verifyCodeIsPresent(JoinPoint point) {

		log.info("verifyCodeIsPresent() --: \n");
		log.info("arg :" + Arrays.toString(point.getArgs()));
		log.info("arg :" + point.getArgs()[0].toString());
		Pizza pizza = (Pizza) point.getArgs()[0];
		pizza.setCode(pizza.getNom().substring(0, 3).toUpperCase());

	}
}
