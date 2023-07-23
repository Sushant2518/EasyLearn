package com.masai.ui;

import java.util.Map;
import java.util.Scanner;

import com.masai.exception.AlreadyUpdatedException;
import com.masai.exception.NoAccountLoggedInException;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;
import com.masai.services.CourseServices;
import com.masai.services.CourseServicesImpl;

public class StudentUI {
	public static void showStudentUi(Scanner sc) {
		int choice = 0;
		do {
			System.out.println("");
			System.out.println("Press 1. Show Current Courses");
			System.out.println("Press 2. Show assignments ");
			System.out.println("Press 3. Show quizzes ");
			System.out.println("Press 4. Show Lectures ");
			System.out.println("Press 5. Update assignment status");
			System.out.println("Press 6. Update Quiz status");
			System.out.println("Press 7. Update Lecture as watched");
			System.out.println("Press 8. See your stats ");
			System.out.println("Press 0. Log out");
			System.out.println("");
			System.out.println("Enter your choice : ");
			choice = sc.nextInt();
			switch (choice) {
			case 1 :
				showCourses(sc);
				break;
			case 2 :
				showAssignemnts(sc);
				break;
			case 3 :
				showQuizzes(sc);
				break;
			case 4 :
				showLectures(sc);
				break;
			case 5 :
				updateAssignmentStatus(sc);
				break;
			case 6 :
				updateQuizStatus(sc);
				break;
			case 7 :
				updateLectureStatus(sc);
				break;
			case 8 :
				showStats(sc);
				break;
			case 0 :
				choice = 0;
				break;
			default :
				System.out.println("invalid choice " + choice);
				break;
			}
		} while (choice != 0);
	}

	private static void showStats(Scanner sc) {
		CourseServices services = new CourseServicesImpl();
		try {

			Map<String, Double> stats = services.showStats();
			System.out.println("");
			System.out.println(
					"+---------------------------------------------------------------------------------------+");
			System.out.println("|" + " Attendence" + "\t" + "|" + "\t" + " Assignment submission rate" + "\t" + "|"
					+ "\t" + " Quiz compleion rate " + "\t" + "|");
			System.out.println(
					"+---------------------------------------------------------------------------------------+");
			System.out.println("|" + " " + stats.get("attendence") + "%" + "\t" + "|" + "\t"
					+ stats.get("assignMentSubmissionRate") + "%" + "\t" + "\t" + "\t" + "\t" + "|" + "\t"
					+ stats.get("quizzesSubmissionRate") + "%" + "\t" + "\t" + "\t" + "|");
			System.out.println(
					"+---------------------------------------------------------------------------------------+");
			System.out.println();
		} catch (NoRecordFoundException | SomethingWentWrongException | NoAccountLoggedInException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void updateLectureStatus(Scanner sc) {
		System.out.print("Enter course Id : ");
		int courseID = sc.nextInt();
		System.out.print("Enter Lecture ID : ");
		int lectureID = sc.nextInt();
		CourseServices services = new CourseServicesImpl();
		try {
			services.updateLectureStatus(courseID, lectureID);
			System.out.println("Lecture status updated successfully .. !");
		} catch (NoRecordFoundException | SomethingWentWrongException | NoAccountLoggedInException
				| AlreadyUpdatedException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void updateQuizStatus(Scanner sc) {
		System.out.print("Enter course Id : ");
		int courseID = sc.nextInt();
		System.out.print("Enter Quiz ID : ");
		int quizID = sc.nextInt();
		System.out.print("1. Mark as pending , 2. Mark as completed (1/2) : ");
		int status = sc.nextInt();
		CourseServices services = new CourseServicesImpl();
		try {
			if (services.updateQuizStatus(courseID, quizID, status)) {
				System.out.println("Quiz is submitted after deadline ");
			} else {
				System.out.println("Quiz status updated before the deadline.. !");
			}

		} catch (NoRecordFoundException | SomethingWentWrongException | NoAccountLoggedInException
				| AlreadyUpdatedException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void updateAssignmentStatus(Scanner sc) {
		System.out.print("Enter Course Id : ");
		int courseID = sc.nextInt();
		System.out.print("Enter Assignment ID : ");
		int assignmentID = sc.nextInt();
		System.out.print("1. Mark as pending , 2. Mark as completed (1/2) : ");
		int status = sc.nextInt();
		CourseServices services = new CourseServicesImpl();
		try {
			if(services.updateAssignmentStatus(courseID, assignmentID, status)) {
				System.out.println("Assignment is submitted after deadline ");
			}else {
				System.out.println("Assignment status updated before the deadline.. !");
			}
			System.out.println("Assignment status updated successfully .. !");
		} catch (NoRecordFoundException | SomethingWentWrongException | NoAccountLoggedInException
				| AlreadyUpdatedException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void showLectures(Scanner sc) {
		CourseServices services = new CourseServicesImpl();
		try {
			services.showLectures().stream().forEach(System.out::println);
		} catch (NoRecordFoundException | SomethingWentWrongException | NoAccountLoggedInException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void showQuizzes(Scanner sc) {
		CourseServices services = new CourseServicesImpl();
		try {
			services.showQuizzes().stream().forEach(System.out::println);
		} catch (NoRecordFoundException | SomethingWentWrongException | NoAccountLoggedInException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void showAssignemnts(Scanner sc) {
		CourseServices services = new CourseServicesImpl();
		try {
			services.showAssignments().stream().forEach(System.out::println);
		} catch (NoRecordFoundException | SomethingWentWrongException | NoAccountLoggedInException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void showCourses(Scanner sc) {
		CourseServices services = new CourseServicesImpl();
		try {
			if (!services.showCourses().isEmpty()) {
				services.showCourses().stream().forEach(System.out::println);
			}
		} catch (NoRecordFoundException | SomethingWentWrongException | NoAccountLoggedInException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
