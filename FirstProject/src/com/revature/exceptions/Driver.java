package com.revature.exceptions;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
	
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int x = 10;
		int y = 0;
		
		//if y == 0 then the stack trace can be hard to read because 
		//multiple things are in line 9
		//divide by zero is an unchecked exception (the compiler doesn't check for it)
		//*this is because it doesn't know at the time that y will be zero and that you will divide with it
		//System.out.println(divide(x,y));
		
		System.out.println(divideTC(x,y));
		
		System.out.println(divideTC(x,5));
		
		System.out.println("reached this line");

	}
	
	static int divide(int x, int y) {
		return x/y;
	}

	static int divideTC (int x, int y) {
		try {
			return x/y;
		} catch (ArithmeticException e) {
			//this will be executed if the exception is thrown
			System.out.println("you can't divide by zero");
			System.out.println(e.getStackTrace()); //
			e.printStackTrace(); //
			return 0;
			
			//finally always executes (typically used to close resources)
		} finally {
			System.out.println("still hit this");
		}
	}
	
	//overloading divideTC with no args in
	static int divideTC () {
		
		try {
		//prompt for number
		System.out.print("put number: ");
		int x = scan.nextInt();
		
		System.out.print("put number: ");
		int y = scan.nextInt();
		
		return x/y;
		} catch (ArithmeticException e) {
			System.out.print("no divide by zero");
		} catch (InputMismatchException f) {
			System.out.print("enter a valid number...");
		} finally {
			scan.close();
		}
		
		return 0;
	}
	
	
	//if you do not have the try/catch you get an unchecked exception
	//checked exceptions force you to handle them at compile time
	static void createFileCheckedException(String path, String text) {
		
		FileWriter write;
		
		try {
			write = new FileWriter(path, true);
			write.write(text);
			write.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //you don't need to have a finally to close the writer because there is no open writer if there is an exception
	}
	
	//try with resources
//	try (/*path of resource being used*/) {
//		//thing you are trying
//	} catch (Exception e) {
//		//handling procedure
//	}
	//this will close the resource like the finally block does above
}
