package com.secd.app.repositories;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.secd.app.models.TeacherModel;

@Repository
public class TeachersRepository {
	public Map<Long, TeacherModel> db2 = new HashMap<>();

    public TeacherModel register(TeacherModel teacher){

        db2.put(teacher.getId(), teacher);
        return teacher;

    }
    
    public TeacherModel login(long id,String email,String pass){

        TeacherModel t = db2.get(id);

        if(t != null && t.getEmail().equals(email) && t.getPass().equals(pass)){
            return t;
        }

        return null;
    }

}
