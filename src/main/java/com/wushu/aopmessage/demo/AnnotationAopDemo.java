package com.wushu.aopmessage.demo;

import com.wushu.aopmessage.config.AppConfig;
import com.wushu.aopmessage.service.MessageService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationAopDemo {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);

		MessageService messageService = context.getBean(MessageService.class);

		messageService.send("Hello");

		try {
			messageService.sendException("Hello");
		} catch (RuntimeException exception) {
			System.out.println("Исключение поймано в main");
		}

		context.close();
	}
}
