package com.revature;

import java.util.ArrayList;
import java.util.List;

/*
 * when do you use an arraylist and when do you use a linked list
 * 
 * arraylist:
 * -best for searching O(1)
 * -worst for inserting/deleting O(n)
 * 
 * Linkedlist:
 * -best for inserting/deleting O(1)
 * -worst for searching can be O(1), but sometimes more complex
 * 
 * we use arraylist here because we aren't adding or deleting chairs once we've built the theater
 * we are only searching to adjust data
 */

public class Theater {

	public String getTheatername() {
		return theatername;
	}

	public void getSeats() {
		
		for (Seat seat : seats) {
			System.out.println(seat.getSeatNumber());
		}
	}
	
	//brute force method
	public boolean reserveSeat(String seatNumber) {
		
		Seat requested = null;
		
		for (Seat seat : seats) {
			if (seat.getSeatNumber().equals(seatNumber)) {
				requested = seat;
				break;
			}
		}
		
		if (requested == null) {
			System.out.println("requested seat does not exist");
			return false;
		}
		
		return requested.reserved();
	}
	
	//binary search algorithm
	public boolean reserveSeatBinary(String seatNumber) {
		
		int low = 0;
		int high = seats.size();
		
		while (low<high) {
			
			System.out.println(";");
			
			//capture the middle value
			int mid = (low + high) / 2;
			
			//use the middle value to capture the middle seat of the row
			Seat midVal = seats.get(mid);
			
			//we have to check if seatNumber passed through is < or > midVal
			//we must make the seats Comparable
			int cmp = midVal.getSeatNumber().compareTo(seatNumber);
			
			//0 if =; -1 if <; 1 if >
			if (cmp < 0) {
				low = ++mid;
			}else if (cmp > 0) {
				high = --mid;
			} else {
				return seats.get(mid).reserved();
			}
		}

		System.out.println("there is no seat " + seatNumber);
		return false;
		
	}
	
	private final String theatername;
	private List<Seat> seats = new ArrayList<>(); //if this were a HashSet, it would not be sorted

	public Theater(String theaterName, int numRows, int seatsPerRow) {
		this.theatername = theaterName;

		int lastRow = 'A' + (numRows - 1);

		for (char row = 'A'; row <= lastRow; row++) {
			// nested for loop for creating the columns of seats against the rows
			for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {

				Seat seat = new Seat(row + String.format("%02d", seatNum));

				seats.add(seat);
			}
		}
	}

	private class Seat implements Comparable<Seat>{
		private final String seatNumber;
		private boolean reserved = false;

		public Seat(String seatNumber) {
			this.seatNumber = seatNumber; // A11-G11
		}
		
		public String getSeatNumber() {
			return seatNumber;
		}
		
		public boolean reserved() {
			if (!this.reserved) {
				this.reserved = false;
				
				System.out.println("Reservation of seat " + seatNumber + " reserved");
				
				return true;
			} else {
				return false;
			}
		}

		//here is how we define the comparison between seats
		public int compareTo(Seat seat) {
			return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
		}
	}

}
