package fr.pizzeria.aspect.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class VerificationCorrectInput {

	private Log log = LogFactory.getLog(this.getClass());

	@Pointcut("execution(public * *(..))")
	private void inrepos() {

	}

	@Around("inrepos()")
	public void verifyCodeIsPresent(JoinPoint point) {

		log.info("runningClass: " + point.getSignature().getClass());
		System.out.println("iciciciciciciciciciciccicicicic");
	}
}
