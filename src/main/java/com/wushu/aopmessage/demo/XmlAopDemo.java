package com.wushu.aopmessage.demo;

import com.wushu.aopmessage.service.MessageService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlAopDemo {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop-xml-config.xml");

		MessageService messageService =
				context.getBean("messageService",  MessageService.class);

		messageService.send("Hello");

		try {
			messageService.sendException("Hello");
		} catch (RuntimeException exception) {
			System.out.println("Исключение поймано в main");
		}

		context.close();
	}
}
