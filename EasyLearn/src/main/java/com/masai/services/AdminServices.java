package com.masai.services;

import com.masai.entity.Course;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public interface AdminServices {
	void addCourses(Course course) throws SomethingWentWrongException;
	void deleteCourseById(int courseID)throws SomethingWentWrongException, NoRecordFoundException;
}
