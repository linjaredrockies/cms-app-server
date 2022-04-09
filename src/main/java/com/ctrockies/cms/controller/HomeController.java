package com.ctrockies.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String greeting(Model model) {
		return "index";
	}
	@GetMapping("/contact")
	public String contact(Model model) {
		return "contactInfo";
	}
}
