package com.revature.abstraction;


//cellphone and desk phone could share an abstract class instead of an interface
public class DeskPhone implements Callable{

	//these two fields should be in an abstract class because they are private
	private int number;
	private boolean ringing;
	
	public DeskPhone(int number) {
		super();
		this.number = number;
	}

	@Override
	public void powerOn() {
		//no action needed
		
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
