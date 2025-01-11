package com.java.studentinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ui")
public class UIController {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private StudentScoreRepository studentScoreRepository;

	@Autowired
	private SubjectRepository subjectRepository;

	@GetMapping("/add-student")
	public String addStudentPage() {
		return "add_student";
	}

	@PostMapping("/add-student")
	public String addStudent(@ModelAttribute Student student) {
		System.out.println("Received student: " + student);
		studentRepository.save(student);
		return "redirect:/ui/students";
	}

	@GetMapping("/add-score")
	public String addScorePage(Model model) {
		model.addAttribute("students", studentRepository.findAll());
		model.addAttribute("subjects", subjectRepository.findAll());
		return "add_score";
	}


	@PostMapping("/add-score")
	public String addScore(@ModelAttribute StudentScore studentScore) {
		studentScoreRepository.save(studentScore);
		return "redirect:/ui/students";
	}

	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentRepository.findAll());
		return "students_list";
	}

	@GetMapping("/students/{id}/details")
	public String viewStudentDetails(@PathVariable Integer id, Model model) {
		model.addAttribute("student", studentRepository.findById(id).orElse(null));
		model.addAttribute("scores", studentScoreRepository.findScoresByStudentId(id));
		return "student_details";
	}
}
