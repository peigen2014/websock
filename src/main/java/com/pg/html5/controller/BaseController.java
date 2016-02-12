package com.pg.html5.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pg.html5.bean.Greeting;
import com.pg.html5.bean.HelloMessage;

@Controller
public class BaseController {

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception {
		Thread.sleep(3000); // simulated delay
		return new Greeting("Hello, " + message.getName() + "!");
	}
	 @RequestMapping("/index")
	    public String sayHello(Model model) {
	        model.addAttribute("message", "こんにちは世界aaa");
	        return "index";
	    }
}
