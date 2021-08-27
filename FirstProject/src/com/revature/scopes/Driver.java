package com.revature.scopes;

public class Driver {

	
	/*
	 * in java there are 4 scopes
	 * 1. class (static/global)
	 * 2.instance (variables beloong to one object only)
	 * 3.method
	 * 4.block (can be nested as you please)
	 * 
	 * the term "field" refers to a static or instance scoped variable
	 * local variable refers to method or block scoped
	 */
	public static void main(String[] args) {
		// instantiate objects

		MyClass myObj = new MyClass();
		
		int x = MyClass.staticVar;
		
		double y = myObj.instVar; //accessed on the instance scope
		
		//static int j = 8; //can't declare variables in a method
		
		//declare a variable on the method scope
		int i = 5;
		
		while(i > 0) {
			//declare a variable in block scope
			int result = i*i;
			System.out.print(result);
			i--;
		}
		
		//you can't access a nested variable from outside it's block scope
		//you can access a variable from a block's parent (that's why you can access i in the above while loop)
		//the while loop is a block
		//System.out.print(result);
	}
	
	public void anotherMethod() {
		int y = MyClass.staticVar;
		
		//can't access another method's variable within another method
		//double w = myObj.instVar; 
		
		String methodVar = "hello";
	}

}
