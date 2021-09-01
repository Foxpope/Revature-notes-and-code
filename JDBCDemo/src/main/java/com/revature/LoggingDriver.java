package com.revature;

import org.apache.log4j.Logger;

public class LoggingDriver {
		//step 1. make a logger
	private static Logger Log = Logger.getLogger(LoggingDriver.class);
	
	public static void main(String[] args) {
		
		
		/*
		 * logging
		 */
		Log.info("App has started");
		
		try {
			recurse();
		} catch (Error e){
			Log.error("something has gone wrong...");
		}
		
		Log.info("something went right");
	}
	
	public static void recurse() {
		recurse();
	}
}
