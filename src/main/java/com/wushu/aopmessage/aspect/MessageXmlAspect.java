package com.wushu.aopmessage.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class MessageXmlAspect {

	public void beforeSend(String message) {
		System.out.println("сейчас будет вызван метод send");
		System.out.println(message + "send");
	}

	public void afterSend() {
		System.out.println("Был вызван метод send");
	}

	public Object measureSendTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.nanoTime();

		try {
			return joinPoint.proceed();
		}  finally {
			long end = System.nanoTime();
			double milliseconds = (end - start) / 1_000_000.0;
			System.out.println("Метод send выполнялся " + milliseconds + " ms");
		}
	}

	public void afterThrowingSendException(RuntimeException exception) {
		System.out.println("Была сгенерирована ошибка");
	}
}
