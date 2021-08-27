package com.revature.controlFlow;

import java.util.Scanner;

public class gradeCalcChallenge {

	public static void main(String[] args) {
		// TODO NA
			
		Scanner scan = new Scanner(System.in);
		
		//get quiz value
		System.out.print("Please enter your the maximum possible quiz score: ");
		double testValue = scan.nextDouble();
		
		//get user score
		System.out.print("Please enter your score: ");
		double score = scan.nextDouble();
		
		//find the letter grade (# is used for grades not between 0 and 100 percent)
		char letterGrade = '#';
		switch ((int)(getPercent(score, testValue)/10)) {
		case 0: 
		case 1: 
		case 2: 
		case 3: 
		case 4: 
		case 5: letterGrade = 'F';
		break;
		case 6: letterGrade = 'D';
		break;
		case 7: letterGrade = 'C';
		break;
		case 8: letterGrade = 'B';
		break;
		case 9:
		case 10: letterGrade = 'A';
		break;
		}
		
		//print info
		System.out.print("The Student's Letter grade is " + letterGrade + ". That's " + 
		removeZeroes(String.valueOf(getPercent(score, testValue))) + "% !");
	}
	
	//returns percent value of first double over second double
	public static double getPercent(double s, double v) { 
		return (s / v) * 100;
	}
	
	//this method removes trailing zeroes and leftover radix if needed
	public static String removeZeroes(String s) {
		while(s.charAt(s.length() - 1) == '0') {
			s = s.substring(0, s.length() - 1);
		}
		if(s.charAt(s.length() - 1) == '.') {
			s = s.substring(0, s.length() - 1);
		}
		return s;
	}

}
