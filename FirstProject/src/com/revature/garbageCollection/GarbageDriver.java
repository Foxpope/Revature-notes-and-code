package com.revature.garbageCollection;

/*
 * Final: 
 * -variable: cannpt be changed
 * -method: cannot be overridden
 * -class: can't be extended
 * -object: can't have it's reference (because you are actually making the pointer value final)
 * 			but you can change the values in the object
 */


//SCARY CODE: PLZ NO RUN, NOT ALWAYS STOP
public class GarbageDriver {

	public static void main(String[] args) {

		System.out.println("Instantiating GD object...");
		
		GarbageDriver gd = new GarbageDriver();
		//the gd reference variable exists in the stack and the object exists in the heap
		
		System.out.println("GD created");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("finally block is running");
		}
		
		gd = null;
		
		/*
		 * garbage collection is non deterministic (you can't control it)
		 * 
		 * every object that extends java.lamg.Object has a special method called finalize
		 * 
		 * when an object's finalize is called
		 */
		
		System.gc();
		
		for(;;) {
			System.out.println("...");
		}

	}
	
	
	
	@Override
	protected void finalize() {
		System.out.println("GC has been called by finalize");
		System.out.println("GC has been called by finalize");
		System.out.println("GC has been called by finalize");
		System.out.println("GC has been called by finalize");
		System.out.println("GC has been called by finalize");
		System.out.println("GC has been called by finalize");
		System.out.println("GC has been called by finalize");
		System.out.println("GC has been called by finalize");
		System.out.println("GC has been called by finalize");
		System.out.println("GC has been called by finalize");
		System.out.println("GC has been called by finalize");
		System.out.println("GC has been called by finalize");
		System.out.println("GC has been called by finalize");
		System.out.println("GC has been called by finalize");
		System.out.println("GC has been called by finalize");
		System.out.println("GC has been called by finalize");
		System.out.println("GC has been called by finalize");
		System.out.println("GC has been called by finalize");
		System.out.println("GC has been called by finalize");
		System.out.println("GC has been called by finalize");
		
		
		
		System.exit(0);
	}

}
