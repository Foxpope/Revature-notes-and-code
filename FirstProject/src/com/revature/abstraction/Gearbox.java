package com.revature.abstraction;

//this is bad practice
public class Gearbox {
	
	private boolean clutchIn;
	
	//an interface is a conctract specifying that the method signatures will not change
	public void operateClutch(boolean operate) {
		this.clutchIn = operate;
	}
	
	//pass in or out
//	public void operateClutch(String operate) {
//		this.clutchIn = operate.equals("in");
//	}
}
