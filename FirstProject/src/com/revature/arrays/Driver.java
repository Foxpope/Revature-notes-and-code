package com.revature.arrays;

import java.util.Arrays;

/*
 * arrays are container objects which contain elements of one type
 * 
 * arrays are static collections, meaning they can't change size
 * 
 * 1. declare the data type it can hold
 * 2. initialize
 */

public class Driver {
	public static void main(String[] args) {
		
		int size = 10;
		
		int[] nums = new int[size]; //default of an int array is 0
		
		String[] words; //step 1
		words = new String[4]; //step 4
		
		byte[] bytes;
		char[] letters;
		Object[] objects;
		
		System.out.println(nums); //this will give unreadable hash key data
		
		System.out.println(Arrays.toString(nums));
		
		//setting a value at an index
		nums[2] = 10;
		
		for(int i = 0; i<nums.length; i++) {
			nums[i] = (i + 1) *10;
		}
		
		System.out.println(Arrays.toString(nums));
		
		//enhanced for loop
		for (int n : nums) {
			System.out.print(n + " ");
		}
		
	}
}
