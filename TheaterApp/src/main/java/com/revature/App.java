package com.revature;

public class App {

	public static void main(String[] args) {

		Theater theater = new Theater("Spotlight", 8, 12);

		//theater.getSeats();
		
		//I want to reserve a seat
		
		//I'll enter the set # and reserve it, it must check if that's possible
		
		
		if(theater.reserveSeatBinary("x215")) {
			System.out.println("please pay");
		} else {
			System.out.println("seat was reserved");
		}
	}

}
