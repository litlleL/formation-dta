package fr.pizzeria.aspect.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class VerificationCorrectInput {

	@Pointcut("execution(* fr.pizzeria.dao.pizza..*.**(..)")
	private void inPizza() {

	}

	@Pointcut("execution(public void save(..))")
	private void allSaveMethod() {

	}

	@Before("inPizza() && allSaveMethod()")
	public void verifyCodeIsPresent(JoinPoint point) {

		System.out.println(point.getSignature().getName());

	}
}
