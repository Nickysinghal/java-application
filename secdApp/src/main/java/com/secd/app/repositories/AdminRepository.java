package com.secd.app.repositories;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.secd.app.models.StudentModel;
import com.secd.app.models.TeacherModel;

@Repository
public class AdminRepository {
	
	@Autowired
	StudentRepository repo;
	
	@Autowired
	TeachersRepository teacherRepo;
	
	public Map<Long,Object> db3 = new HashMap<>();

    public void addUser(long id,Object user){
        db3.put(id, user);

    }

    public Object getUser(long id){
        return db3.get(id);

    }
	
	public void manageAccess(long id) {
		Object user = db3.get(id);
		if(user!=null) {
			
			if(user instanceof StudentModel) {

	            StudentModel s = (StudentModel) user;
	            s.setBanned(!s.isBanned());

	        }
	        else if(user instanceof TeacherModel) {

	            TeacherModel t = (TeacherModel) user;
	            t.setBanned(!t.isBanned());
	        }
		}
		
	} 
	
	public void updateUser(long id,Map<String, Object> data) {
		Object user = db3.get(id);

	    if(user != null) {

	        if(user instanceof StudentModel) {

	            StudentModel s = (StudentModel) user;

	            if(data.containsKey("rollNo"))
	                s.setRollNo(Long.parseLong(data.get("rollNo").toString()));

	            if(data.containsKey("course"))
	                s.setCourse(data.get("course").toString());
	        }
	        
	        else if(user instanceof TeacherModel) {

	            TeacherModel t = (TeacherModel) user;

	            if(data.containsKey("name"))
	                t.setName(data.get("name").toString());

	            if(data.containsKey("sectionAssigned"))
	                t.setSectionAssigned(data.get("sectionAssigned").toString());

	            if(data.containsKey("email"))
	                t.setEmail(data.get("email").toString());
	        }
	        
	    }

	}
	
	public void deleteUser(long id) {
		Object user = db3.get(id);
		if(user!=null) {
			db3.remove(id);
			if(user instanceof StudentModel) {
				repo.db.remove(id);
			}else if(user instanceof TeacherModel) {
				teacherRepo.db2.remove(id);
			}

			
		}
	} 
	

}
