package com.revature.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.InputMismatchException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.exceptions.NotAGradeException;
import com.revature.models.Course;
import com.revature.models.Student;
import com.revature.util.utilityMethods;

public class StudentTests {

	static Student dummyStudent;
	static Course c1;
	static Course c2;
	static ArrayList<Course> courses;
	
	@Before
	public void setUp() {
		courses = new ArrayList<Course>();
		
		c1 = new Course("Math101");
		c2 = new Course("Math401");
		
		courses.add(c1);
		courses.add(c2);
	}
	
	@After
	public void tearDown() {
		c1 = null;
		c2 = null;
		courses = null;
		
		dummyStudent = null;
	}
	
	@Test
	public void whenInstantiateStudent_thenIncrementStaticID() {
		
		dummyStudent = new Student("dummo", "dummerson", 2);
		
		//when this was written, there was no getID, this is a good example of
		//why you should write tests
		String actualID = dummyStudent.getID();
		
		String expectedID = "41001";
		
		assertEquals(actualID, expectedID);
	}
	
	//we need to test custom exceptions
	@Test(expected = NotAGradeException.class)
	public void badGradeExceptionAboveBounds() {
		int badGrade = 7;
		utilityMethods.validateGradeYear(badGrade);
	}
	
	//below range
	@Test(expected = NotAGradeException.class)
	public void badGradeExceptionBelowBounds() {
		int badGrade = -7;
		utilityMethods.validateGradeYear(badGrade);
	}
	
	//input mismatch test
	@Test(expected = InputMismatchException.class)
	public void badGradeInputMismatch() {
		
		char badGrade = 'h';
		
		Student guy = new Student("guy", "guyson", badGrade);
	}
	
	//test driven development is when we write the test after the method
}
