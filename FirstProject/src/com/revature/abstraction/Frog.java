package com.revature.abstraction;

public class Frog extends Animal implements Ectothermic, Amphibious{

	@Override
	public void makeSound() {
		System.out.print("croak");
	}

	// overload
	public void makeSound(int times) {
		for (int i = 0; i < times; i++) {
			System.out.print("croak");
		}
	}

	@Override
	public void heatUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void coolDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void swim() {
		// TODO Auto-generated method stub
		
	}

}
