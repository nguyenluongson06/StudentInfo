package com.java.studentinfo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "student_t")
@Getter @Setter
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "student_id")
	private Integer studentId;

	@NotNull
	@Column(name = "student_code")
	private String studentCode;

	@NotNull
	@Column(name = "full_name")
	private String fullName;

	@NotNull
	@Column(name = "address")
	private String address;

	// Getters and Setters
}
