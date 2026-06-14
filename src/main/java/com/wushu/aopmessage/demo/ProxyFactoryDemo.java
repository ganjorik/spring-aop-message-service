package com.wushu.aopmessage.demo;

import com.wushu.aopmessage.proxy.MessageInterceptor;
import com.wushu.aopmessage.service.MessageService;
import com.wushu.aopmessage.service.MessageServiceImpl;
import org.springframework.aop.framework.ProxyFactory;

public class ProxyFactoryDemo {

	public static void  main(String[] args) {

		MessageService target = new MessageServiceImpl();

		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(target);
		proxyFactory.addAdvice(new MessageInterceptor());

		MessageService proxy = (MessageService) proxyFactory.getProxy();

		System.out.println("-----target-----");
		target.send("Hello");

		System.out.println("-----proxy-----");
		proxy.send("Hello");

	}
}
