package com.secd.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.secd.app.models.StudentModel;
import com.secd.app.models.TeacherModel;
import com.secd.app.repositories.AdminRepository;

@RestController
public class AdminController {
	@Autowired
	AdminRepository adminRepo;
	
	@PatchMapping("/admin/manage_access/{id}")
	public String manageAccessUser(@PathVariable long id) {
		
		Object user = adminRepo.db3.get(id);
		
		if(user!=null) {
			if(user instanceof StudentModel) {
				StudentModel student = (StudentModel) user;
				student.setBanned(false);
				return "student is un-banned";
			} 
			if(user instanceof TeacherModel) {
				TeacherModel teacher = (TeacherModel) user;
				teacher.setBanned(false);
				return "teacher is un-banned";
			}
			return "User(teacher/student) is banned";
		}
		return "user does not exist";
		
	}
}
