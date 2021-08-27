package com.revature.models;

/*
 * this class inherits from java.lang.Object
 * 
 * a class is a template for an object
 * you can only have one public class per file
 */
public class Person {
	
	//static means that this variable is accessible on a class level
	public static int MAX_AGE = 115;
	
	//instance variables
	private String name;
	private int age;
	private double height;
	private double weight;
	
	//getters and setters (ALT + SHIFT + S brings up the menu to make these immediately)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	//there was a constructor for this class but it was abstracted away
	//now it is not, but it needs an argument to work now
	public Person(String name) {
		super(); //super calls the parent constructor (in this case, it's from Object; 
				 //which is always called, so it isn't strictly necessary here)
		this.name = name;
	}
	
	public Person(String name, int age, double height, double weight) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
	public Person() {
		//this is a called a no-args constructor since I wrote instead of using the abstracted one
	}
	
	public double calculateBMI(double height, double weight) {
		return (weight/height/height)*783;
	}
	
	//here we override the Object class toString
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight + "]";
	}
}

//you can have more than one class though
class House {
	
}