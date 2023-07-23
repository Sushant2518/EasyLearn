package com.masai.ui;

import java.util.List;
import java.util.Scanner;

import com.masai.entity.Course;
import com.masai.entity.Student;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;
import com.masai.services.DataServices;
import com.masai.services.DataServicesImpl;

public class InstructorUI {
	public static void showInstructorUi(Scanner sc) {
		int choice = 0;
		do {
			System.out.println("");
			System.out.println("Press 1. See All courses");
			System.out.println("Press 2. See All students");
			System.out.println("Press 3. Add new Assignment ");
			System.out.println("Press 4. Add new Quiz ");
			System.out.println("Press 5. Post new lecture");
			System.out.println("Press 6. See all lectures by course ID ");
			System.out.println("Press 7. See all assignments by course ID");
			System.out.println("Press 8. See all quizzes by course ID ");
			System.out.println("Press 9. Delete Lecture by lecture ID ");			
			System.out.println("Press 10. Delete Assignment by assignment ID ");			
			System.out.println("Press 11. Delete Quiz by quiz ID ");			
			System.out.println("Press 0. Exit");
			System.out.print("Enter your choice : ");
			choice = sc.nextInt();
			switch (choice) {
			case 1 :
				showCourses();
				break;
			case 2 :
				showStudents();
				break;
			case 3 :
//				addAssignment(sc);
				break;
			case 4 :
//				addQuiz(sc);
				break;
			case 5 :
//				addLecture(sc);
				break;
			case 6 :
//				seeAllLecturesByCourseID(sc);
				break;
			case 7 :
//				seeAllAssignmentsByCourseID(sc);
				break;
			case 8 :
//				seeAllQuizzesByCourseID(sc);
				break;
			case 9 :
//				deleteLectureByLectureID(sc);
				break;
			case 10 :
//				deleteAssignmentByAssignmentID(sc);
				break;
			case 11 :
//				deleteQuizByQuizID(sc);
				break;
			case 0 :
				choice = 0;
				break;
			default :
				System.out.println("invalid choice "+ choice);
				break;
			}
		} while (choice != 0);
	}

	private static void showStudents() {
		DataServices services = new DataServicesImpl();
		try {
			List<Student> showStudents = services.showStudents();
			if (showStudents == null) {
				System.out.println("No student found in DataBase");
				return;
			}
			showStudents.stream().forEach(System.out::println);
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void showCourses() {
		DataServices services = new DataServicesImpl();
		try {
			List<Course> showCourse = services.showCourses();
			if (showCourse == null) {
				System.out.println("No Courses found in DataBase");
				return;
			}
			showCourse.stream().forEach(System.out::println);
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
