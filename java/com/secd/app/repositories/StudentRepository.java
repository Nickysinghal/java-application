package com.secd.app.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.secd.app.models.StudentModel;


@Repository
public class StudentRepository {
	
Map<Integer, StudentModel> db = new HashMap<Integer, StudentModel>();
	
	
//	@Autowired
//	AdminRepository adminRepo;

	
	public StudentModel register(int id, long rollNo, String name, String course, String branch, String email, String pass ) {
		StudentModel newStudent = new StudentModel(id, rollNo, name, course, branch, email, pass);
		try {
			db.put(id, newStudent);
//			 adminRepo.addUser((long)newStudent.getUid(), newStudent);

			return newStudent;
		} catch (Exception e) {
			return null;
		}
	} 
	
	
	
	public StudentModel login(int id, String email, String pass) {
		StudentModel student = db.get(id);
		if(student != null) {
			if(student.getEmail().equals(email) && student.getPass().equals(pass) && !student.isBanned()) {
				return student;
			}
			return null;
		}
		return null;
	}
//	Map<Long, StudentModel> db = new HashMap<Long, StudentModel>();
////	int current = 1;
//	
//	//Create Student
//	public StudentModel createStudent(long id,long rollNo, String name, String course,String branch, String email, String pass){
//		StudentModel newStudent = new StudentModel();
//		db.put(newStudent.getRollNo(), newStudent);
////		current ++;
//		return newStudent;
//	}

	
//	
//	public StudentModel loginUser(Map<String, String> loginUser) {
//		long loginId =Long.parseLong(loginUser.get("id"));
//		String loginEmail = loginUser.get("email");
//		String loginPass = loginUser.get("pass");
//		
//		//here we are now searching for the user in the database
//		
//		StudentModel user =  db.get(loginId);
//		
//		if(user != null && user.getEmail().equals(loginEmail) && user.getPass().equals(loginPass)) {
//			return user;
//		}
//		else {
//			return null;
//		}
//	}
//	
	
	//Read All
	public ArrayList<StudentModel> showAll(){
		ArrayList<StudentModel> list = new ArrayList<StudentModel>();
		list.addAll(db.values());
		return list;
	}
	
	//Read One
	public StudentModel showOne(int id) {
		return db.get(id);
	}
	
	//reset Password
	public StudentModel resetPass(int id, String pass) {
		try {
			StudentModel student = db.get(id);
			student.setPass(pass);
			return student;
			
		}catch(Exception e){
			return null;
		}
		
	}
	
//	public boolean deleteStudent(long id) {
//	    if(db.containsKey(id)) {
//	        db.remove(id);
//	        return true;
//	    }
//	    return false;
//	}
}