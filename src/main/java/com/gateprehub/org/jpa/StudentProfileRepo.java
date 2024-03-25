package com.gateprehub.org.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gateprehub.org.models.StudentProfile;

public interface StudentProfileRepo extends JpaRepository<StudentProfile, Integer>{
	
}