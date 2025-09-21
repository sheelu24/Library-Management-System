package entity;

import java.util.Date;

public class Patron {

	static int pId =1;
	
	private String name;
	private int id;
	private Date joiningDate;
	
	public Patron(String name) {
		this.name = name;
		this.id = pId++;
		this.joiningDate = new Date();
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
	
}
