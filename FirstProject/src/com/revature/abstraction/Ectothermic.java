package com.revature.abstraction;

public interface Ectothermic {
	//all methods in a interface are abstract and public
	//all attributes are public static and final
	public static final int MIN_TEMP = -40;
	
	void heatUp();
	
	void coolDown();
	
	//there are also default
	default void saySomething() {
		System.out.print("saying something from default interface");
	}
	
}
