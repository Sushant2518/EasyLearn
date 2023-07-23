package com.masai.dao;

import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public interface LoginDAO {
	Boolean LoginInstructor(String username,String password) throws NoRecordFoundException, SomethingWentWrongException;
	Boolean LoginStudent(String username, String password)throws NoRecordFoundException, SomethingWentWrongException;
}
