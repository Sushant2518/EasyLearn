package com.masai.dao;

import com.masai.entity.Course;
import com.masai.exception.SomethingWentWrongException;

public interface AdminDAO {
	void addCourses(Course course)throws SomethingWentWrongException;
}
