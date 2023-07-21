package com.masai.dao;

import com.masai.entity.Course;
import com.masai.entity.Student;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public interface AdminDAO {
	void addCourses(Course course)throws SomethingWentWrongException;
	void deleteCourseById(int courseID)throws SomethingWentWrongException, NoRecordFoundException;
	Course findCourseById(int courseID)throws NoRecordFoundException;
	Student findStudentById(int studentId)throws NoRecordFoundException;
	void assignCoureToStudent(int[] courseIDs, int studentId)throws SomethingWentWrongException, NoRecordFoundException;
	void deleteStudentById(int studentId)throws SomethingWentWrongException, NoRecordFoundException;
}
