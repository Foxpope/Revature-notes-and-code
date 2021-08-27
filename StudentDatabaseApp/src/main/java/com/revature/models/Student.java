package com.revature.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
	/*
	 * TODO
	 * enroll()
	 */

	//every time you make a new student, this will increment once
	private static int globalID = 1000;
	private Scanner scan = new Scanner(System.in);
	
	public Student(String firstName, String lastName, int gradeYear) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gradeYear = gradeYear;
		setID();
		
		System.out.println(firstName + " " + lastName + " " + gradeYear + " " + ID);
	}
	
	public String getID() {
		return ID;
	}

	private String firstName;
	private String lastName;
	private int gradeYear;
	private String ID; //String to help concatenating to ID
	private List<Course> courses = new ArrayList<Course>();
	//this is a dynamic datastructure that is inferring generics
	//arraylists allow you to add and remove
	private double tuitionBalance = 0;
	
	//keep in mind, you should always use the most restrictive access modifiers that still allow you to use a method
	private void setID() {
		globalID++;
		this.ID = gradeYear + "" + globalID; //the "" makes it treat the int as a string
	}
	
	public void viewBalance() {
		System.out.println("Your balance is: $" + tuitionBalance);
	}
	
	public void payTuition() {
		viewBalance();
		
		System.out.println("Enter your payment: $");
		double payment = scan.nextDouble();
		
		System.out.println("thanks for your payment of: " + payment);
		
		viewBalance();
		}
	
	public void showStatus() {
		System.out.println("\nName: " +firstName+ " "+ lastName + "\nStudent ID: " + ID
				+ "\nCourses enrolled in: " + courses.toString() + "\nTuition: " + tuitionBalance);
	}
	
	public void enroll() {
		List<Course> coursesToAdd = new ArrayList<Course>();
		
		boolean done = false;
		
		while(!done) {
			System.out.println("Enter a course to enroll in: ");
			
			String courseName = scan.next();
			
			if (!courseName.equalsIgnoreCase("q")) {
				
				Course newCourse = new Course(courseName);
				
				coursesToAdd.add(newCourse);
				tuitionBalance += Course.cost;
				
				scan.nextLine();
			} else {
				//if they hit q for quit
				System.out.println("-quitting-");
				done = true;
			}
		}
		
		courses = coursesToAdd;
		
		System.out.print("Enrolled in: " + courses.toString());
	}
}
