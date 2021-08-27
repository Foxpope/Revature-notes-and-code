package com.revature.arrays;

import java.util.Scanner;

public class interactiveArrays {
	
	//static binds this field to the class scope
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		int size = 5;
		
		int[] returned = getIntegers(size);
		
		printArray(returned);
		
		double avg = getAverage(returned);
		
		System.out.print(avg);
	}
	
	static int[] getIntegers(int capacity) {
		System.out.println("Enater " + capacity + " integers");
		
		int[] values = new int[capacity];
		
		for(int i=0; i<values.length; i++) {
			values[i] = scan.nextInt();
		}
		
		return values;
	}
	
	//follow up for challenge (find the average of an array
	static double getAverage(int[] array) {
		
		double sum = 0;
		
		for(int i = 0; i<array.length; i++) {
			sum += (double)array[i];
		}
		
		return sum/(double)array.length;
	}
	
	static void printArray(int[] array) {
		for(int n : array) {
			System.out.print(n);
		}
	}

}
