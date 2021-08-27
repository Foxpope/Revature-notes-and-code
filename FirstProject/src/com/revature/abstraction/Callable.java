package com.revature.abstraction;

public interface Callable {

	//all methods are public and abstract
	void powerOn();
	void dial(int number);
	boolean call(int number);
	boolean ringing();
}
