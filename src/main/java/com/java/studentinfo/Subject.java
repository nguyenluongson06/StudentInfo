package com.java.studentinfo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "subject_t")
@Getter @Setter
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subject_id")
	private Integer subjectId;

	@NotNull
	@Column(name = "subject_code")
	private String subjectCode;

	@NotNull
	@Column(name = "subject_name")
	private String subjectName;

	@NotNull
	@Column(name = "credit")
	private Integer credit;

	// Getters and Setters
}
