package com.revature;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.exceptions.*;
import com.revature.models.Student;

public class Driver {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		run();

	}

	public static void run() {

		// #of students to enroll
		System.out.println("Enter number of students to enroll: ");

		int numOfStudents = scan.nextInt();

		Student[] students = new Student[numOfStudents];

		// iterate over the array to add students to each index
		// this could br done with an enhanced for loop, but you would need getters and
		// setters in Student (it would get hairy)
		for (int i = 0; i < numOfStudents; i++) {

			System.out.println("Enter student first name: ");
			String firstName = scan.next();

			System.out.println("Enter student last name: ");
			String lastName = scan.next();

			int year = 0;

			//can also be done with boolean flag (which may be easier with more complex operations)
			while (year < 1 || year > 4) {
				try {
					System.out.println("Enter grade year 1-4: ");
					year = scan.nextInt();
				} catch (NotAGradeException e) {
					System.out.print(e.getMessage());
				} catch (InputMismatchException f) {
					System.out.println("Just encountered a " + f + ". Enter number from 1-4");
				} finally {
					scan.nextLine();
				}
			}

			students[i] = new Student(firstName, lastName, year);
			
			students[i].enroll();
		}
	}

}
