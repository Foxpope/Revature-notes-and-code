package com.revature.util;

import com.revature.exceptions.*;

//a class that just holds useful methods
public class utilityMethods {

	public static void validateGradeYear(int grade) throws NotAGradeException {
		
		if (grade < 1 || grade > 4) {
			throw new NotAGradeException("Enter a valid grade (1-4)");
		}
	}
	
	//public static void
}
