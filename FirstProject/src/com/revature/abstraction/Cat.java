package com.revature.abstraction;

public class Cat extends Animal{

	//abstraction makes legs and properties present but abstracted away
	private String breed;
	private boolean hasFur;
	
	public Cat() {
		super();
		this.breed = breed;
	}
	
	//getter and setters (ALT+SHIT+S to get menu for this)
	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public boolean isHasFur() {
		return hasFur;
	}

	public void setHasFur(boolean hasFur) {
		this.hasFur = hasFur;
	}

	@Override
	public void makeSound() {
		System.out.print("meow");
	}

}
