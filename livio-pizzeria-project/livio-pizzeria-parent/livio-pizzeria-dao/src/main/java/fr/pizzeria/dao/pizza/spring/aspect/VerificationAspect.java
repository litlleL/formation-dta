package fr.pizzeria.dao.pizza.spring.aspect;

import java.util.Arrays;
import java.util.Date;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.pizza.spring.repos.perf.PerfReposDao;
import fr.pizzeria.model.Performance;
import fr.pizzeria.model.Pizza;

@Aspect
@Component
public class VerificationAspect {

	private Logger log = Logger.getLogger(VerificationAspect.class.getName());

	@Pointcut("execution(* fr.pizzeria..*.save(..))")
	private void anySaveMethod() {
	}

	@Before("anySaveMethod()")
	public void verifyCodeIsPresent(JoinPoint point) {

		log.info("verifyCodeIsPresent() --: \n");
		log.info("arg :" + Arrays.toString(point.getArgs()));
		log.info("arg :" + point.getArgs()[0].toString());
		Pizza pizza = (Pizza) point.getArgs()[0];
		pizza.setCode(pizza.getNom().substring(0, 3).toUpperCase());

	}

	@Pointcut("execution(* fr.pizzeria.dao.pizza..*.*(..))")
	private void anyMethod() {

	}

	// @Around("anyMethod()")
	public void calculPerf(ProceedingJoinPoint joinPoint) throws Throwable {

		log.info("calculPerf() --: \n");
		long startTime = System.currentTimeMillis();

		joinPoint.proceed();

		long endTime = System.currentTimeMillis();
		Performance performance = new Performance(joinPoint.getClass().getName(), new Date(), (endTime - startTime));

		PerfReposDao perf = new PerfReposDao();
		perf.save(performance);
	}
}
