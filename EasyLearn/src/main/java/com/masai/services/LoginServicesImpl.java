package com.masai.services;

public class LoginServicesImpl implements LoginServices{

	@Override
	public Boolean LoginAdmin(String username, String password) {
		if(username.equals("admin") && password.equals("admin")) 
			return true;
		return false;
	}

}
