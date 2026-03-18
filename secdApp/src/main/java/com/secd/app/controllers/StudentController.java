package com.secd.app.controllers;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.secd.app.models.StudentModel;
import com.secd.app.repositories.AdminRepository;
import com.secd.app.repositories.StudentRepository;

@RestController
public class StudentController {
	
//	StudentRepository repo = new StudentRepository();
	@Autowired
	StudentRepository repo;

	@Autowired
	AdminRepository adminRepo;
	//Register
	
	@PostMapping("/student/register")
	public String studentRegister(@RequestBody StudentModel newStudent) {
		long id = newStudent.getUid();
		long rollNo = newStudent.getRollNo();
		String name = newStudent.getName();
		String course = newStudent.getCourse();
		String branch = newStudent.getBranch();
		String email = newStudent.getEmail();
		String pass = newStudent.getPass();
		
		//adding to db3 for all users and db for student
		StudentModel newStu = repo.register(id, rollNo, name, course, branch, email, pass);
		adminRepo.addUser(id, newStudent);
		
		if(newStu != null) {
			
			return "Registration Successful";
		}
		return "Registration Failed.";
	}
	
	//Login
	
	@PostMapping("/student/login")
	public String login(@RequestBody Map<String, String> loginUser) {
		long id =  Long.parseLong(loginUser.get("id"));
		String email = loginUser.get("email");
		String pass = loginUser.get("pass");
		
		StudentModel login = repo.login(id, email, pass);
		if(login != null) {
			return "Login Successful";
		}
		return "Login Failed.";
	} 
	
	@GetMapping("/student/show_all")
	public ArrayList<StudentModel> showAll(){
		return repo.showAll();
	}
}

	//Reset Password
	
	//View Attendance
	