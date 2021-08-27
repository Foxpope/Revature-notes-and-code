package com.revature;

public class MainMethodDemo {

	/*
	 * JIT ssearches for main method
	 * args is an array of commands that could follow the execution command
	 */
	public static void main(String[] args) {
		System.out.println("testing this");
		
		//print out the args with enhanced for loop
		for (String n : args) {
			System.out.println(n);
		}
		
		//explicitly print the 3rd word (T/C needed in case there are not enough args)
		try {
			System.out.println(args[3]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("not enough args");
		}
	}

}
