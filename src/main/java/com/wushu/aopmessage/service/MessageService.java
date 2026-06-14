package com.wushu.aopmessage.service;

public interface MessageService {

	void send(String message);

	void sendException(String message);
}
