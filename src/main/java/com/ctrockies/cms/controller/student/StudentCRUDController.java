package com.ctrockies.cms.controller.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.ctrockies.cms.data.Student;
import com.ctrockies.cms.repository.StudentRepository;

@Controller
public class StudentCRUDController {
	@Autowired
	private StudentRepository repository;

	@RequestMapping(value = "/student/add", method = RequestMethod.GET)
	public String launchAdd(Model model) {
		Student student = new Student(0, "", "", "");
		model.addAttribute("student", student);
		return "student/add";
	}

	@RequestMapping(value = "/student/add", method = RequestMethod.POST)
	public String add(@ModelAttribute Student student, Model model, RedirectAttributes redirectAttributes) {
		try {
			repository.save(student);
			redirectAttributes.addFlashAttribute("message", "The student (ID: " + student.getStudentNumber()
					+ ", Name: " + student.getFirstName() + " " + student.getLastName() + ") has been added.");
			return "redirect:/studentList";
		} catch (Exception ex) {
			model.addAttribute("student", student);
			return "student/add";
		}
	}
}
