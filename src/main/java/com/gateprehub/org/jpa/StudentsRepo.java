package com.gateprehub.org.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gateprehub.org.models.Student;

public interface StudentsRepo extends JpaRepository<Student, Integer>{
	@Query("Select u from Student u where u.username = ?1")
	public Student findbyUserName (String username);
}
