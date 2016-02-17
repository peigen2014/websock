package com.pg.html5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pg.html5.bean.Greeting;
import com.pg.html5.bean.HelloMessage;

@Controller
public class WebSocketController {
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;

	@MessageMapping("/webChat/{chatNo}")
	public void greeting(HelloMessage message, @DestinationVariable("chatNo") String chatNo) throws Exception {
		simpMessagingTemplate.convertAndSend("/topic/chatNo." + chatNo,
				new Greeting("Hello, " + message.getName() + "!"));
	}

	@RequestMapping("/sendMsg")
	public String sendMsg() {
		simpMessagingTemplate.convertAndSend("/topic/chatNo.1", new Greeting("Hello, " + "message.getName()" + "!"));
		return "index";
	}
}
