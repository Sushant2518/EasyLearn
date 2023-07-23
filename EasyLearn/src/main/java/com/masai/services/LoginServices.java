package com.masai.services;

import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public interface LoginServices {
	Boolean LoginAdmin(String username, String password);
	Boolean  LoginStudent(String username,String password) throws SomethingWentWrongException, NoRecordFoundException;
	Boolean LoginInstructor(String username,String password) throws SomethingWentWrongException, NoRecordFoundException;
}
