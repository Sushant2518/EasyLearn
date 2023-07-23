package com.masai.ui;

import java.util.Arrays;
import java.util.Scanner;

import com.masai.entity.Course;
import com.masai.entity.State;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;
import com.masai.services.*;

public class AdminUI {

	public static void adminFunction(Scanner sc) {
		int choice = 0;
		do {
			System.out.println("*****Welcome To Admin Side*****");
			System.out.println("Press 1. Add course");
			System.out.println("Press 2. Assign courses to student ");
			System.out.println("Press 3. Delete course by ID");
			System.out.println("Press 4. Delete student by ID");
			System.out.println("Press 5. Delete Instructor by ID ");
			System.out.println("Press 6. Show course stats ");
			System.out.println("");
			System.out.print("Enter your choice : ");
			choice = sc.nextInt();
			switch(choice) {
			case 1 :
				addCourse(sc);
				break;
			case 2 :
				assignCoureToStudent(sc);
				break;
			case 3 :
				deleteCourseById(sc);
				break;
			case 4 :
				deleteStudentById(sc);
				break;
			case 5 :
				deleteInstructorById(sc);
				break;
			case 6 :
//				showCourseStats(sc);
				break;
			default :
				System.out.println("invalid choice, please try again ");
			}
		}while(choice!=0);
		
	}


	private static void deleteInstructorById(Scanner sc) {
		System.out.print("Enter Instructor ID : ");
		int instrucorID = sc.nextInt();
		AdminServices services = new AdminServicesImpl();
		try {
			services.deleteInstructorById(instrucorID);
			System.out.println("Instrucor deleted successfully .. !");
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}


	private static void deleteStudentById(Scanner sc) {
		System.out.print("Enter student ID : ");
		int studentId = sc.nextInt();
		AdminServices services = new AdminServicesImpl();
		try {
			services.deleteStudentById(studentId);
			System.out.println("Student deleted successfully .. !");
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void assignCoureToStudent(Scanner sc) {
		System.out.println("Enter student id : ");
		int StudentId = sc.nextInt();
		System.out.println("Enter course id's (space seperated vaues only) : ");
		sc.nextLine();
		int[] courseIDs = Arrays.stream(sc.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
	
		AdminServices services = new AdminServicesImpl();
		try {
			services.assignCoureToStudent(courseIDs, StudentId);
			System.out.println("courses assinged to student ");
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void deleteCourseById(Scanner sc) {
		System.out.print("Enter course ID : ");
		int courseID = sc.nextInt();
		AdminServices services = new AdminServicesImpl();
		try {
			services.deleteCourseById(courseID);
			System.out.println("course deleted successfully .. !");
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void addCourse(Scanner sc) {
		System.out.print("Enter course Name :");
		String courseName = sc.next();
		
		Course course = new Course(courseName);
//		course.setCourseStatus(State.ACTIVE);
		AdminServices services = new AdminServicesImpl();
		
		try {
			services.addCourses(course);
			System.out.println("Course added succesfully .. !");
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}
}
