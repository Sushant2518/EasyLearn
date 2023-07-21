package com.masai.services;

import com.masai.entity.Instructor;
import com.masai.entity.Student;
import com.masai.exception.SomethingWentWrongException;

public interface RegisterServices {
	String registerStudent(Student student) throws SomethingWentWrongException;
	String registerInstructor(Instructor instructor) throws SomethingWentWrongException;
}
