package com.ctrockies.cms.controller.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ctrockies.cms.data.Student;
import com.ctrockies.cms.repository.StudentRepository;

@Controller
public class StudentListController {
    @Autowired
    private StudentRepository repository;
	@GetMapping("/studentList")
	public String list(Model model) {
		List<Student> students = (List<Student>) repository.findAll();
		model.addAttribute("students", students);
		return "student/studentList.html";
	}
}
