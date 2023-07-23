package com.masai.services;

import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;
import com.masai.dao.LoginDAO;
import com.masai.dao.LoginDAOImpl;
public class LoginServicesImpl implements LoginServices{

	@Override
	public Boolean LoginAdmin(String username, String password) {
		if(username.equals("admin") && password.equals("admin")) 
			return true;
		return false;
	}

	@Override
	public Boolean LoginStudent(String username, String password)
			throws SomethingWentWrongException, NoRecordFoundException {
		LoginDAO loginDAO = new LoginDAOImpl();
		return loginDAO.LoginStudent(username, password);
	}

	@Override
	public Boolean LoginInstructor(String username, String password)
			throws SomethingWentWrongException, NoRecordFoundException {
		LoginDAO loginDAO = new LoginDAOImpl();
		return loginDAO.LoginInstructor(username, password);
	}

}
