package com.revature.strings;

public class Driver {

	public static void main(String[] args) {
		
		/*
		 * Strings are used to store a sequence of characters
		 * treated as objects
		 * they are from the string class
		 * 
		 * 1. string object created with the new keyword -> goes to general heeap
		 * 2. string literal created with "some sentence" -> goes to string pool
		 */
		
		String object = new String("I go to the heap");
		System.out.println(object);
		
		String literal = "I go to the string pool";
		System.out.println(literal);
		
		String s1 = "hello";
		String s2 = "hello";
		
		//.equals checks for the value
		System.out.println("Is s1 the same as s2? " + s1.equals(s2));
		
		//do they the same location
		System.out.println("do they have the same location? " + (s1 == s2));
		
		String object2 = new String("hello");
		//does this point to the same place
		System.out.println("does object2 have the same location as s1 and s2? " + (object2 == s1));
		
		String s3 = "hello world"; //in string pool
		
		String s4 = "hello " + "world";
		
		System.out.println(s3 == s4); //the + operator is smart enough to make this work
		
		System.out.println("hascode of the string literal s1: " + s1.hashCode());
		System.out.println("hashcode of string object2: " + object2.hashCode());
		//they are the same object, but they don't point to the same place in memory
		
		String s5 = "hello ";
		String s6 = s5 + "world";
		
		//to send something to the string pool, call the intern() method
		
		System.out.println(s6 == s3);
		
		String poolString1 = s6.intern();
		
		System.out.println("has poolString1 been sent to the pool? " + (poolString1 == s3));
		
		/*
		 * String API
		 * 
		 * indexOf()
		 * charAt()
		 * ...etc.
		 */
		
		String  newObject = poolString1.concat("something"); //creates a new string, doesn't modify the old one
		
		System.out.println(newObject);
		
		String test = "The farmer in the dell";
		
		String chopped = test.substring(5);
		System.out.println(chopped);
		
		//StringBuffer and StringBuilder are mutable forms of String
		//StringBuffer is threadsafe, but slower than StringBuilder
		
		StringBuilder sBuild = new StringBuilder("hello");
		
		sBuild.append(" ");
		sBuild.append("world"); //modifying the same object, unlike with regular strings
		
		//you can send the Stringbuilder outside the string pool
		System.out.println(sBuild);
		String myString = sBuild.toString(); //now it's outside the string pool
		System.out.println(myString);
		
		String poolString = myString.intern();
		
		System.out.println(poolString1 == myString); //false
		System.out.println(poolString == poolString1); //true because we interned
		
	}

}
