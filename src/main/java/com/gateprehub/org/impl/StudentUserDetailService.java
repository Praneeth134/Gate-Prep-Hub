package com.gateprehub.org.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gateprehub.org.jpa.StudentsRepo;
import com.gateprehub.org.models.Student;

@Service
public class StudentUserDetailService implements UserDetailsService {

    @Autowired
    private StudentsRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Student student = userRepo.findbyUserName(username);
        if (student == null) {
            throw new UsernameNotFoundException(username);
        }
        UserDetails userDetails = User.withUsername(student.getName()).password(student.getPassword()).authorities("USER").build();
        return userDetails;
    }
}
