package com.masai.dao;

import com.masai.entity.Instructor;
import com.masai.entity.Student;
import com.masai.exception.SomethingWentWrongException;

public interface RegisterDao {
	String registerInstructor(Instructor instructor) throws SomethingWentWrongException;
	String registerStudent(Student student)throws SomethingWentWrongException;
}
