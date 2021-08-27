package com.revature.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.models.Course;

//test suite is a grouping of unit tests for one specific class
public class CourseTest {

	
	//create some dummy objects (stubs)
	static Course c1;
	static Course c2;
	
	//this is an annotation that tells the compiler something about the method
	//this one tells it that this method has to be run before anything else
	@BeforeClass
	public static void setupBeforeClass() throws Exception {
		
		System.out.print("running before all tests in class");
	}
	
	@AfterClass
	public static void setupAfterClass() throws Exception {
		
		System.out.println("running after all tests in class");
	}
	
	//execute before each test
	@Before
	public void setup() {
		
		System.out.println("setting up");
		
		c1 = new Course("English 101");
		c2 = new Course("English 403");
	}
	
	@After
	public void tearDown() {
		c1 = null;
		c2 = null;
	}
	
	
	//a test test
	@Test
	public void test1() {
		System.out.println("I'm a test");
	}
	
	//testing getName
	@Test
	public void testGetName() {
		
		String expected = "English 101";
		String actual = c1.getName();
		
		assertEquals(expected, actual);
	}
	
	//testing setName
	@Test
	public void testSetName() {
		
		String courseName = "Blah 406";
		
		c1.setName(courseName);
		
		assertTrue(c1.getName().equals(courseName));
	}
}
