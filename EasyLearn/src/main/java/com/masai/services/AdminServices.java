package com.masai.services;

import com.masai.entity.Course;
import com.masai.exception.SomethingWentWrongException;

public interface AdminServices {
	void addCourses(Course course) throws SomethingWentWrongException;
}
