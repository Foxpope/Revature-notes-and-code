package com.revature.abstraction;

//this cannot be instantiated
public abstract class Animal {
	
	public int legs;
	private String color;
	
	//abstract is not an access modifier
	//abstract methods are meant to be inherited but have no implementation
	public abstract void makeSound();
	
	
	
	public void exist() {
		System.out.println("this animal exists");
	}
}
