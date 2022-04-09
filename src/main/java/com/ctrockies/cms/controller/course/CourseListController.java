package com.ctrockies.cms.controller.course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseListController {
	@GetMapping("/courses")
	public String list(Model model) {
		return "course/courseList.html";
	}
}