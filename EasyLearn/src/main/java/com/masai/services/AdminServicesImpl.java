package com.masai.services;

import com.masai.dao.AdminDAO;
import com.masai.dao.AdminDAOImpl;
import com.masai.entity.Course;
import com.masai.exception.SomethingWentWrongException;

public class AdminServicesImpl implements AdminServices{

	@Override
	public void addCourses(Course course) throws SomethingWentWrongException {
		AdminDAO adminDAO = new AdminDAOImpl();
		adminDAO.addCourses(course);
	}

}
