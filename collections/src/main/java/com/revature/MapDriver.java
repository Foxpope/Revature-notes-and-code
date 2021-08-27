package com.revature;

import java.util.HashMap;
import java.util.Map;

public class MapDriver {

	public static void main(String[] args) {
		
		//create a simple HashMap
		Map<String, String> languages = new HashMap<String, String>();

		//use the .put() to insert into a map
		languages.put("Java", "a compiled, high-level, OOP, platform independent language");
		languages.put("Python", "an interpreted OOP lang");
		languages.put("JavaScript", "lightweight interpreted language");
		
		/*
		 * the map interface does not extend iterable
		 * 
		 * -you cannot have duplicate keys
		 * -but you can duplicate values
		 */
		languages.put("JavaScript", "not java");
		
		System.out.println("I like to program in  Java, which is " + languages.get("Java"));
		
		/*
		 * How to iterate over a Map?
		 */
		
		// want to get all keys
		
		for (String key : languages.keySet()) {
			System.out.println("the key is " + key);
		}
		
		//for values it's essentially the same
		
		//how do we iterate over both the keys and the value in the MAp?
		for(Map.Entry<String, String> entry : languages.entrySet()) {
			System.out.println(entry);
		}
		
		System.out.println("we just removed " + languages.remove("Java"));
		
	}

}
