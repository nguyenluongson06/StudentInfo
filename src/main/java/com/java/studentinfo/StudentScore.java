package com.java.studentinfo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student_score_t")
@Getter @Setter
public class StudentScore {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_score_id")
	private Integer studentScoreId;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;

	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;

	@Column(name = "score1")
	private Double score1;
	@Column(name = "score2")
	private Double score2;

	// Calculated grade
	public String getGrade() {
		double finalScore = 0.3 * score1 + 0.7 * score2;
		if (finalScore >= 8.0) return "A";
		if (finalScore >= 6.0) return "B";
		if (finalScore >= 4.0) return "D";
		return "F";
	}

	// Getters and Setters
}
