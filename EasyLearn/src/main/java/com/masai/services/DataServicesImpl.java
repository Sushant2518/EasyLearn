package com.masai.services;

import java.util.List;

import com.masai.entity.Course;
import com.masai.entity.Student;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;
import com.masai.dao.DataDAO;
import com.masai.dao.DataDAOImpl;

public class DataServicesImpl implements DataServices{

	@Override
	public List<Student> showStudents() throws SomethingWentWrongException, NoRecordFoundException {
		DataDAO dataDAO = new DataDAOImpl();
		return dataDAO.showStudents();
	}

	@Override
	public List<Course> showCourses() throws SomethingWentWrongException, NoRecordFoundException {
		DataDAO dataDAO = new DataDAOImpl();
		return dataDAO.showCourses();
	}
	
}
