package com.revature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;

import com.revature.model.Animal;

/*
 * list
 * -ordered collection (by insertion)
 * -may contain duplicates
 * -we use the list interface when we want to use the following operations
 * 
 * =	positional access
 * 		-manipulating elements based on their numerical position
 * 		-using CRUD operations (fill this acronym)
 */
public class CollectionDriver {

	public static void main(String[] args) {
		List<Animal> animals = new ArrayList<>();

		Animal a1 = new Animal("Dog", 12);
		Animal a2 = new Animal("Dingo", 32);
		Animal a3 = new Animal("Dog", 12);
		
		animals.add(a3);
		animals.add(a1);
		animals.add(a2);
		
		for (Animal a : animals) {
			System.out.println(a.hashCode());
		}
		
		//vectors double in size when they need to expand
		List<Integer> numbers = new Vector<Integer>();
		
		numbers.add(3);
		numbers.add(-9000);
		numbers.add(74);
		
		System.out.println("=============");
		
		System.out.println(numbers);
		
		/*
		 * Sets
		 * -unordered
		 * -no duplicates allowed (maintain astrong contract of the object and its hashcode and equls()
		 * 
		 */
		
		Set<Animal> animals2 = new HashSet<Animal>();
		
		animals2.add(a3);
		animals2.add(a1);
		animals2.add(a2);
		
		System.out.println("=============");
		
		for (Animal a : animals2) {
			System.out.println(a);
		}
		
		/*
		 * queue
		 * -used to hold elements prior to processing
		 * -FIFO (first in first out)
		 * -
		 */
		
		Queue<Animal> animalsQ = new LinkedList<Animal>();
		
		animalsQ.add(a3);
		animalsQ.add(a1);
		animalsQ.add(a2);

		System.out.println("=============");
		
		while(animalsQ.size() != 0) {
			System.out.println("Queue size: " + animalsQ.size());
			System.out.println("Processing... " + animalsQ.poll()); //poll removes the head of the queue
		}
		
		/*collections utility class (note the 's'; this is different from the collection interface)
		 *  -static methods that operate on a collection
		 *  -polymorphic algorithms
		 */
		
		System.out.println("=============");
		
		System.out.println("vector before sorting");
		System.out.println(numbers);
		
		System.out.println("sorting vector...");
		Collections.sort(numbers); 
		
		System.out.println(numbers);
		
		
	}

}
