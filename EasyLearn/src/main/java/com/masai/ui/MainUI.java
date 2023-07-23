package com.masai.ui;

import java.util.Scanner;
import com.masai.ui.RegisterUI;

public class MainUI {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;

		do {
			System.out.println("**********Welcome To EASY LEARN**********");
			System.out.println("Press 1. Admin Login");
			System.out.println("Press 2. Register as Instructor");
			System.out.println("Press 3. Instructor Login");
			System.out.println("Press 4. Register as Student");
			System.out.println("Press 5. Student Login");
			System.out.println("Press 0. Exit app");
			System.out.println("");
			System.out.print("Enter your choice : ");
			choice = sc.nextInt();
			System.out.println("");
			switch (choice) {
			case 1 :
				LoginUI.adminLogin(sc);
				break;
			case 2 :
				RegisterUI.registerInstrucor(sc);
				break;
			case 3 :
				LoginUI.instructorLogin(sc);
				break;
			case 4 :
				RegisterUI.registerStudent(sc);
				break;
			case 5 :
				LoginUI.studentLogin(sc);
				break;
			case 0 : 
				System.out.println("Thanks for using our services .. !");
				break;
			default :
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 0);

	}

}
