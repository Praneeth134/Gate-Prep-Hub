package com.gateprehub.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.gateprehub.org.jpa.StudentProfileRepo;
import com.gateprehub.org.jpa.StudentsRepo;
import com.gateprehub.org.models.Contact;
import com.gateprehub.org.models.ContactRepo;
import com.gateprehub.org.models.Student;
import com.gateprehub.org.models.StudentProfile;

@Controller
public class Main {
	@Autowired
	StudentsRepo userRepo;

	@Autowired
	StudentProfileRepo userProfileRepo;

	@Autowired
	ContactRepo contactRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@ModelAttribute
	public void modelData(Model m) {
		m.addAttribute("name", "Users");
	}

	@RequestMapping("/")
	public String home() {
		return "gatePrepHub";
	}

//	@RequestMapping("/login")
//	public String login() {
//	return "my-account";
//	}
//
//	@RequestMapping("/signup")
//	public String signup() {
//		return "signup";
//	}
//
//	@RequestMapping("/profile")
//	public String profile() {
//		return "profile";
//	}
//
//	@RequestMapping("/contact.html")
//	public String contact() {
//		return "contact";
//	}
//
//	@RequestMapping("/Contact")
//	public String contact1() {
//		return "contact";
//	}
// "about","contact","computerscience","electrical","mechanical","lost-password","my-account"
//	@GetMapping("getUser")
//	public String getUser(Model m) {
//		m.addAttribute("index", repo.findAll());
//		return "index";
//	} 

	@GetMapping("/{filename}")
    public String handleFileRequest(@PathVariable String filename) {
        // Do something with the file
        return filename; // Assuming you have a view resolver configured
    }
	
//	@GetMapping("getUser")
//	public String getUser(@RequestParam int Id, Model m) {
//		m.addAttribute("result", userRepo.getOne(Id));
//		return "result";
//	}

	@PostMapping(value = "signup")
	public String addUser(@ModelAttribute Student u) {
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		userRepo.save(u);
		return "result";
	}

	@PostMapping(value = "updateProfile")
	public String updateProfile(@ModelAttribute StudentProfile u) {
		userProfileRepo.save(u);
		return "result";
	}

	@PostMapping(value = "Contact")
	public String updateProfile(@ModelAttribute Contact u) {
		contactRepo.save(u);
		return "result";
	}

//	@RequestMapping("/addUser")
//	public String addUser() {
//		return "result";
//	}
}
