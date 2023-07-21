package com.masai.services;

import com.masai.entity.Instructor;
import com.masai.entity.Student;
import com.masai.exception.SomethingWentWrongException;
import com.masai.dao.RegisterDao;
import com.masai.dao.RegisterDaoImpl;

public class RegisterServicesImpl implements RegisterServices{

	@Override
	public String registerStudent(Student student) throws SomethingWentWrongException {
		RegisterDao registerDao = new RegisterDaoImpl();
		return registerDao.registerStudent(student);
	}

	@Override
	public String registerInstructor(Instructor instructor) throws SomethingWentWrongException {
		RegisterDao registerDao = new RegisterDaoImpl();
		return registerDao.registerInstructor(instructor);
	}

}
