package com.revature.serialization;

public class Driver {

	public static void main(String[] args) {
		//instantiate pet
				PetStore petco = new PetStore();
				PetStore petsmart = new PetStore();
				
				//2 ways to add a pet object to petco's db
				//1. first instantiate, then add
				Pet p1 = new Pet("Finn", 1004, "Cat", "Jerry", 4, Color.GREY);
				petco.petDB.add(p1);
				//2. immediately call collection, add and instantiate at once
				petco.petDB.add(new Pet("Spit", 1009, "Dingo", "Dan", 12, Color.BROWN));
				
				System.out.println("Below is our arraylist from petco");
				//another way to prin this list
//				System.out.println(petco.petDB);
//				
//				System.out.println("****************");
				
				//enhanced for loop
				for (Pet p : petco.petDB) {
					System.out.println(p.getName());
				}
				
				petco.serialize();
				petsmart.deserialize();
				
				for (Pet newPet : petsmart.petDB) {
					System.out.println("deserialized pet is: " + newPet.getName());
				}

	}

}
