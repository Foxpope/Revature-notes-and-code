package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

/*
 * a JAVA bean is a type of POJO, but more specific:
 * -it's serializable
 * -has getters/setters
 * -have an overridden hashcode() and equals() method
 * 
 * serialization is the process of persisting an object from memory
 * to sequence of bits (to, for instance, save to disk
 */
public class Employee extends Person implements Serializable{
	
	//all the properties are present in Employee but abstracted away from us
	private String dept;

	public Employee(String name, int age, double height, double weight, String dept) {
		super(name, age, height, weight); //super() calls the constructor of the parent (Person)
		this.dept = dept;
	}

	//the other getters and setters already exist in abstract
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return super.toString() + " dept=" + dept + "]"; //fix this later
	}

	@Override
	public int hashCode() {
		return Objects.hash(dept); //this started in java 7
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(dept, other.dept);
	}
	
	
}
