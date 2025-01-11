package com.java.studentinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private SubjectRepository subjectRepository;
	@Autowired
	private StudentScoreRepository studentScoreRepository;

	@PostMapping("/students")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		return ResponseEntity.ok(studentRepository.save(student));
	}

	@PostMapping("/scores")
	public ResponseEntity<StudentScore> addScore(@RequestBody StudentScore score) {
		return ResponseEntity.ok(studentScoreRepository.save(score));
	}

	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents() {
		return ResponseEntity.ok(studentRepository.findAll());
	}

	@GetMapping("/students/{id}/scores")
	public ResponseEntity<List<StudentScore>> getScoresForStudent(@PathVariable Integer id) {
		return ResponseEntity.ok(studentScoreRepository.findScoresByStudentId(id));
	}
}
