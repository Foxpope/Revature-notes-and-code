package com.revature.dataTypes;

import java.util.*;

public class driver {

	/**
	 * the main method is where the JIT 
	 * compiler begins execution.
	 * the JIT is part of the JVM
	 * @param args
	 */
	public static void main(String[] args) {
		//8 primitives
		boolean a = true; //1 bit of reserved mem
		byte b =127; //8 bits of reserved mem
		short c = 32467; //16 bits of mem
		char d = 'm'; //16 bits
		
		int e = 100; //32 bits
		float lessPreciseDecimal = 93.2f; //32 bits
		
		double decimal = 145.63; //64 bits
		long verLarge = 12345L; //64 bits
		
		//since java 7 you can use an _ for readability
		
		long creditCardNum = 2134_5678_4567_7693L; //remember the 'L' for longs
		
		int x = 4;
		int y = 10;
		
		System.out.println(x + y);
		
		//String is a CLASS, not a data type
		String name = "PorousRobert";
		
		System.out.println(name + " is " + (x + y) *100 + " years old");
		
		//Casting
		
		byte f = 40;
		short g = f; //shorts are larger than bytes, so we can widen the variable
		
		//widening is the implicit casting of a variable from a smaller to larger data type
		
		double dub = 900.9;
		int myInt = (int) dub;
		
		System.out.println("the double has been explicitly cast to a smaller data type: " + myInt);
		//this is called narrow casting
		
		//everything above is java literals; just hard coded values assigned to variables
		
		int min;
		min = Integer.MIN_VALUE; //static values are available from the class level
		
		//completely convert primitive data type to an object
		//(AUTOBOXING) prim -> object
		Integer obj1 = new Integer(20);
		Integer obj2 = new Integer("20");
		
		//do obj1 and obj2 have the same value?
		System.out.println(obj1.equals(obj2));
		
		//are they the same object in the heap?
		System.out.println(obj1 == obj2);
		
		//convert the double obj to a primitive
		Double dubl = 15.45;
		Double dubl2 = new Double(15.45);
		double dubPrim = dubl; //implicit way to transform it
		
		double dubPrim2 = Double.valueOf(dubl);
		
		//if i were to use something with
		List<Double> dubList = new ArrayList<Double>();
		
		//CTRL + SHIFT + O TO AUTO IMPORT EVERYHTING
		dubList.add(dubl);
		dubList.add(dubl2);
		
		/*
		 * wrapper classes
		 * unboxing
		 * autoboxing
		 * 
		 * == vs .equals();
		 */
		
	}
}
