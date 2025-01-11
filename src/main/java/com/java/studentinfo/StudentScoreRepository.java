package com.java.studentinfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentScoreRepository extends JpaRepository<StudentScore, Integer> {
	@Query("SELECT ss FROM StudentScore ss WHERE ss.student.studentId = ?1")
	List<StudentScore> findScoresByStudentId(Integer studentId);
}
