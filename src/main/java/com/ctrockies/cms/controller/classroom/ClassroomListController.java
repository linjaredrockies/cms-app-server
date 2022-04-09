package com.ctrockies.cms.controller.classroom;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClassroomListController {
	@GetMapping("/classrooms")
	public String list(Model model) {
		return "classroom/classroomList.html";
	}
}