package com.ctrockies.cms.controller.teacher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeacherListController {
	@GetMapping("/teachers")
	public String list(Model model) {
		return "teacher/teacherList.html";
	}
}