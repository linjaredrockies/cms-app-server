package com.ctrockies.cms.controller.schedule;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ScheduleController {
	@GetMapping("/schedule")
	public String list(Model model) {
		return "schedule/schedule.html";
	}
}