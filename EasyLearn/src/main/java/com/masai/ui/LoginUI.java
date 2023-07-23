package com.masai.ui;

import java.util.Scanner;

import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;
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
	
	
	public static void instructorLogin(Scanner sc) {
		System.out.print("Enter username : ");
		sc.nextLine();
		String username = sc.nextLine().trim();
		System.out.print("Enter password : ");
		String password = sc.nextLine();
		LoginServices services = new LoginServicesImpl();
		try {
			if (services.LoginInstructor(username, password)) {
				System.out.println("Login succes .. !");
				InstructorUI.showInstructorUi(sc);
			} else {
				System.out.println("incorrect username or password ");
			}
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void studentLogin(Scanner sc) {
		System.out.print("Enter username : ");
		sc.nextLine();
		String username = sc.nextLine().trim();
		System.out.print("Enter password : ");
		String password = sc.nextLine();
		LoginServices iLs = new LoginServicesImpl();
		try {
			if (iLs.LoginStudent(username, password)) {
				System.out.println("Login succes .. !");
				StudentUI.showStudentUi(sc);
			} else {
				System.out.println("incorrect username or password ");
			}
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
