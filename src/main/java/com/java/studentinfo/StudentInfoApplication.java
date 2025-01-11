package com.java.studentinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.*;

@SpringBootApplication
public class StudentInfoApplication {
	public static void main(String[] args) {
		SpringApplication.run(StudentInfoApplication.class, args);
	}
}

