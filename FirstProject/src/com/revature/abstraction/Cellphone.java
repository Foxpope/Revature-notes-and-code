package com.revature.abstraction;

public class Cellphone implements Callable{

	private int number;
	private boolean ringing;
	private boolean on;
	
	public Cellphone(int number) {
		this.number = number;
		this.on = true;
	}

	@Override
	public void powerOn() {
		this.on = true;
		System.out.println("on");
		
	}

	@Override
	public void dial(int number) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean call(int number) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ringing() {
		// TODO Auto-generated method stub
		return false;
	}
}
