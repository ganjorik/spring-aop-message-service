package com.wushu.aopmessage.service;

import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

	@Override
	public void send(String message) {
		System.out.println("Отправка сообщения: " + message);
	}

	@Override
	public void sendException(String message) {
		throw new RuntimeException("Ошибка при отправке сообщения: " + message);
	}
}
