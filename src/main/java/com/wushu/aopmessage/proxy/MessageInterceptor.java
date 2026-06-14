package com.wushu.aopmessage.proxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MessageInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

		if("send".equals(invocation.getMethod().getName())) {

			String message = (String) invocation.getArguments()[0];

			System.out.println("Сообщение перехвачено: " + message);
		}

		return invocation.proceed();
	}
}
