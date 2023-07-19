package com.masai.ui;

import java.util.Scanner;
import com.masai.services.*;

public class LoginUI {
	public static void adminLogin(Scanner sc) {
		System.out.println("Enter UserName : ");
		String username = sc.next();
		System.out.println("Enter Password : ");
		String password = sc.next();
		
		LoginServices login = new LoginServicesImpl();
		
		if(login.LoginAdmin(username, password)) {
			AdminUI.adminFunction(sc);
			System.out.println("Login Successfully!!");
		}
		else {
			System.out.println("Wrong username or password");
		}
	}
}
