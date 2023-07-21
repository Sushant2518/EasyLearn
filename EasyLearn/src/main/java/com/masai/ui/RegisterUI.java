package com.masai.ui;

import java.util.Scanner;

import com.masai.entity.Instructor;
import com.masai.entity.State;
import com.masai.entity.Student;
import com.masai.entity.User;
import com.masai.exception.SomethingWentWrongException;
import com.masai.services.RegisterServices;
import com.masai.services.RegisterServicesImpl;


public class RegisterUI {
	public static void registerInstrucor(Scanner sc) {
		User instructor = new Instructor();
		System.out.print("Enter name : ");
		sc.nextLine();
		instructor.setName(sc.nextLine().trim());
		System.out.print("Enter username : ");
		instructor.setUsername(sc.nextLine());
		System.out.print("Enter password : ");
		instructor.setPassword(sc.next());
		instructor.setAccountStatus(State.ACTIVE);
		
		RegisterServices services = new RegisterServicesImpl();
		try {
			System.out.println(services.registerInstructor((Instructor) instructor));
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void registerStudent(Scanner sc) {
		User student = new Student();
		System.out.print("Enter name : ");
		sc.nextLine();
		student.setName(sc.nextLine().trim());
		System.out.print("Enter username : ");
		student.setUsername(sc.nextLine());
		System.out.print("Enter password : ");
		student.setPassword(sc.next());
		student.setAccountStatus(State.ACTIVE);
		RegisterServices services = new RegisterServicesImpl();
		try {
			System.out.println(services.registerStudent((Student) student));
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}
}
