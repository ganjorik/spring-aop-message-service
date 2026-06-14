package com.wushu.aopmessage.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MessageAnnotationAspect {

	@Pointcut("execution(* com.wushu.aopmessage.service.MessageService.send(..))")
	public void sendPointcut() {
	}

	@Before("sendPointcut() && args(message)")
	public void beforeSend(String message) {
		System.out.println("сейчас будет вызван метод send");
		System.out.println(message + " send");
	}

	@AfterReturning("sendPointcut()")
	public void afterSend(String message) {
		System.out.println("Был вызван метод send");
	}

	@Around("sendPointcut()")
	public Object measureSendTime(ProceedingJoinPoint jointPoint) throws Throwable {
		long start = System.nanoTime();

		try {
			return jointPoint.proceed();
		} finally {
			long end = System.nanoTime();
			double milliseconds = (end - start) / 1_000_000.0;
			System.out.println("Метод send выполнялся " + milliseconds + " ms");
		}
	}

	@AfterThrowing(
			pointcut = "execution(* com.wushu.aopmessage.service.messageService.sendException(..))",
			throwing = "exception"
	)
	public void afterThrowingSendException(RuntimeException exception) {
		System.out.println("Была сгенерирована ошибка");
	}
}
