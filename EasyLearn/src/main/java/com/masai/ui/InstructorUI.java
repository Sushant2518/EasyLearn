package com.masai.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.masai.entity.Assignment;
import com.masai.entity.Course;
import com.masai.entity.Lecture;
import com.masai.entity.Quiz;
import com.masai.entity.State;
import com.masai.entity.Status;
import com.masai.entity.Student;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;
import com.masai.services.DataServices;
import com.masai.services.DataServicesImpl;
import com.masai.utility.EMUtilis;
import com.masai.utility.IdGeneration;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

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
			System.out.println("Press 0. Log out");
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
				addAssignment(sc);
				break;
			case 4 :
				addQuiz(sc);
				break;
			case 5 :
				addLecture(sc);
				break;
			case 6 :
				seeAllLecturesByCourseID(sc);
				break;
			case 7 :
				seeAllAssignmentsByCourseID(sc);
				break;
			case 8 :
				seeAllQuizzesByCourseID(sc);
				break;
			case 9 :
				deleteLectureByLectureID(sc);
				break;
			case 10 :
				deleteAssignmentByAssignmentID(sc);
				break;
			case 11 :
				deleteQuizByQuizID(sc);
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

	private static void deleteQuizByQuizID(Scanner sc) {
		System.out.print("Enter Course ID : ");
		int courseID = sc.nextInt();
		System.out.print("Enter quiz ID : ");
		int quizID = sc.nextInt();
		DataServices services = new DataServicesImpl();
		try {
			services.deleteQuizByQuizID(courseID,quizID);
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void deleteAssignmentByAssignmentID(Scanner sc) {
		System.out.print("Enter Course ID : ");
		int courseID = sc.nextInt();
		System.out.print("Enter assignment ID : ");
		int assignmentID = sc.nextInt();
		DataServices services = new DataServicesImpl();
		try {
			services.deleteAssignmentByAssignmentID(courseID,assignmentID);
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void deleteLectureByLectureID(Scanner sc) {
		System.out.print("Enter Course ID : ");
		int courseID = sc.nextInt();
		System.out.print("Enter Lecture ID : ");
		int lectureID = sc.nextInt();
		DataServices services = new DataServicesImpl();
		try {
			services.deleteLectureByLectureID(courseID,lectureID);
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void seeAllQuizzesByCourseID(Scanner sc) {
		System.out.print("Enter course ID : ");
		int courseID = sc.nextInt();
		DataServices services = new DataServicesImpl();
		try {
			services.seeAllQuizzesByCourseID(courseID).stream().forEach(System.out::println);
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void seeAllAssignmentsByCourseID(Scanner sc) {
		System.out.print("Enter course ID : ");
		int courseID = sc.nextInt();
		DataServices services = new DataServicesImpl();
		try {
			services.seeAllAssignmentsByCourseID(courseID).stream().forEach(System.out::println);
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void seeAllLecturesByCourseID(Scanner sc) {
		System.out.print("Enter course ID : ");
		int courseID = sc.nextInt();
		DataServices services = new DataServicesImpl();
		try {
			services.seeAllLecturesByCourseID(courseID).stream().forEach(System.out::println);
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void addLecture(Scanner sc) {
		System.out.print("Enter Course Id : ");
		int courseId = sc.nextInt();

		System.out.print("Enter Lecture Title : ");
		sc.nextLine();
		String title = sc.nextLine();

		System.out.print("Enter description of Lecture : ");
		String desc = sc.nextLine();

		System.out.println("Enter URL of lecture (zoom or meet link) : ");
		String url = sc.nextLine();

		Lecture lecture = new Lecture(IdGeneration.generateID(), title, desc, Status.PENDING, LocalDate.now(), url,
				State.ACTIVE);

		DataServices services = new DataServicesImpl();
		try {
			services.addLecture(courseId, lecture);
			System.out.println("Lecture posted Successfully..!");
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void addQuiz(Scanner sc) {
		System.out.print("Enter Couse Id : ");
		int courseId = sc.nextInt();

		System.out.print("Enter Quiz Title : ");
		sc.nextLine();
		String title = sc.nextLine();

		System.out.print("Enter details of Quiz : ");
		String desc = sc.nextLine();

		System.out.print("Enter deadLine of Quiz (in YYYY-MM-DD format) : ");
		LocalDate deadLine = LocalDate.parse(sc.next());

		Quiz quiz = new Quiz(IdGeneration.generateID(), title, desc, Status.PENDING, LocalDate.now(), deadLine,
				State.ACTIVE);

		DataServices services = new DataServicesImpl();
		try {
			services.addQuiz(courseId, quiz);
			System.out.println("Quiz added Successfully..!");
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void addAssignment(Scanner sc) {
		System.out.print("Enter Couse Id : ");
		int courseId = sc.nextInt();

		System.out.print("Enter Assignment Title : ");
		sc.nextLine();
		String title = sc.nextLine();

		System.out.print("Enter description of assignment : ");
		String desc = sc.nextLine();

		System.out.print("Enter deadLine of assignment (in YYYY-MM-DD format) : ");
		LocalDate deadLine = LocalDate.parse(sc.next());

		Assignment assignment = new Assignment(IdGeneration.generateID(), title, desc, Status.PENDING, LocalDate.now(),
				deadLine, State.ACTIVE);

		DataServices services = new DataServicesImpl();
		try {
			services.addAssignment(courseId, assignment);
			System.out.println("Assignment added Successfully..!");
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
		
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
