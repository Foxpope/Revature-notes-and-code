package com.revature.controlFlow;

import java.util.Scanner;

public class driver {

	public static void main(String[] args) {
		// if-else

		int temp = 31;

		// ternary operator
		System.out.print(((temp < 32) ? "COLD!" : "not cold") + "\n");

		// switch case

		Scanner scan = new Scanner(System.in);
		double testValue = 1;
		double score = 0;

		do {
			// get quiz value
			System.out.print("Please enter your the maximum possible quiz score: ");
			testValue = scan.nextDouble();

			// get user score
			System.out.print("Please enter your score: ");
			score = scan.nextDouble();
		} while ((testValue < score) || (testValue < 0) || (score < 0));

		// find the letter grade (# is used for grades not between 0 and 100 percent)
		char letterGrade; // no need to initialize here, as long as we ensure it gets done in the switch
		switch ((int) ((score / testValue) * 10)) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			letterGrade = 'F';
			break;
		case 6:
			letterGrade = 'D';
			break;
		case 7:
			letterGrade = 'C';
			break;
		case 8:
			letterGrade = 'B';
			break;
		case 9:
		case 10:
			letterGrade = 'A';
			break;
		default:
			letterGrade = '#';
			System.out.println("the values provided have produced an out of range percent score");
		}

		System.out.println("the grade is " + letterGrade);

		// for loops

		// count up
		for (int i = 0; i < 3; i++) {
			System.out.println(i + 1);
		}

		// spell a word
		System.out.print("give me a word and I'll spell it: ");
		String word = scan.next();

		for (int i = 0; i < word.length(); i++) {
			System.out.print(word.charAt(i) + " ");
		}

	}
}