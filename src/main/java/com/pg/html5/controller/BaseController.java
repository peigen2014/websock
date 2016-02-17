package com.pg.html5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {
	@RequestMapping("/index")
	public String sayHello(Model model) {
		model.addAttribute("message", "hello world");
		return "index";
	}

}
