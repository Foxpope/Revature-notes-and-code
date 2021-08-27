package com.revature;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Hello world!");
		run();
	}
	
	static private void run() {
		Scanner scan = new Scanner(System.in);
        
		int num = 0, den = 0;
		
        try {
            num = scan.nextInt();
            den = scan.nextInt();
        } catch (InputMismatchException e) {
        	e.printStackTrace();
        	System.exit(0);
        }
        
        try {
        	System.out.print(num/den);
        } catch (ArithmeticException e) {
        	e.printStackTrace();
        	System.exit(0);
        }
        
        scan.close();
	}

}
