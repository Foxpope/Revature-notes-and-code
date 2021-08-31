package com.revature;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TestingGrounds {
	public static void main(String[] args) {
		thing("one/\ntwo three two Meow two one");
	}

	public static void thing(String string) {
		String onlyLetters = string.replaceAll("[^(a-z || A-Z) ]", " ");
		
		Scanner scan = new Scanner(onlyLetters);
		String word;
		//map to be returned
		Map<String, Integer> wordCount = new HashMap<>();

		//flag to exit while when no words are left
		boolean i = true;
		while (i) {
			//try catch handles no such element if there is no more string left to parse
			try {
				word = scan.next();
				//operates differently for first occurrence and later occurrences
				if (wordCount.containsKey(word)) {
					wordCount.put(word, wordCount.get(word) + 1);
				} else {
					wordCount.put(word, 1);
				}
			} catch (NoSuchElementException e) {
				//switches flag to exit while loop
				i = false;
			}
		}
		scan.close();
		
		System.out.println(wordCount.toString());
	}
}
