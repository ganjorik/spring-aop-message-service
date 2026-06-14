package com.wushu.aopmessage.service;

public class MessageServiceImpl implements MessageService {

	@Override
    public void send(String message) {
		System.out.println(message + " send");
	}
}
