package com.leopompeu.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Controlador da Index
@Controller
public class indexController {
	
	//Puxando a página de login
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	//Puxando a Index
	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
