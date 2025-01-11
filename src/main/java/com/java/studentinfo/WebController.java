package com.java.studentinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WebController {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private StudentScoreRepository studentScoreRepository;

	@GetMapping("/students")
	public String viewStudents(Model model) {
		model.addAttribute("students", studentRepository.findAll());
		return "students";
	}

	@GetMapping("/students/{id}")
	public String viewStudentScores(@PathVariable Integer id, Model model) {
		model.addAttribute("scores", studentScoreRepository.findScoresByStudentId(id));
		return "student_scores";
	}
}
