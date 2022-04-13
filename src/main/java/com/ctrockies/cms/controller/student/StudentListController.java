package com.ctrockies.cms.controller.student;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.ctrockies.cms.data.Student;
import com.ctrockies.cms.repository.StudentRepository;

@Controller
public class StudentListController {
    @Autowired
    private StudentRepository repository;
	@GetMapping("/studentList")
	public String list(Model model, HttpServletRequest request) {
		List<Student> students = (List<Student>) repository.findAll();
		model.addAttribute("students", students);
	    Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
	    if (inputFlashMap != null) {
	        String message = (String) inputFlashMap.get("message");
			model.addAttribute("message", message);
	    }
		return "student/studentList.html";
	}
}
