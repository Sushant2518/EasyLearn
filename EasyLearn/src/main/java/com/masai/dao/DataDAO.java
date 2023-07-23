package com.masai.dao;

import java.util.List;

import com.masai.entity.Course;
import com.masai.entity.Student;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public interface DataDAO {
	List<Student> showStudents() throws SomethingWentWrongException, NoRecordFoundException;
	List<Course> showCourses() throws SomethingWentWrongException, NoRecordFoundException;
}
