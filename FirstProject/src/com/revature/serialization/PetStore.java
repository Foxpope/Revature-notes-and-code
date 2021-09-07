package com.revature.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PetStore {

	
	//every pet store has a database
	//we can put an array list here and infer it will hold pet objects
	//List = arraylist is used so that you have more flexibility to change it later
	List<Pet> petDB = new ArrayList<>();
	
	public List<Pet> getPetDB() {
		return petDB;
	}
	public void setPetDB(List<Pet> petDB) {
		this.petDB = petDB;
	}
	//serialize method
	public void serialize() {
		
		//we're writing to a file, we need to use the java.io package
		//remember the try with resource, this will close the stream if it meets these errors
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("files/pet.db"))) {
			//this is what we want to execute
			oos.writeObject(this.petDB);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//deserialize method
	public void deserialize() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("files/pet.db"))) {
			//when a petstore calls this method, it will call it on its petdb array
			this.petDB = (ArrayList<Pet>) ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
