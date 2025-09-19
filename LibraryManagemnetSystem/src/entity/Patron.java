package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Patron {

	static int pId =1;
	
	private String name;
	private int id;
	private Date joiningDate;
	private List<Lending> lending;
	
	
	public Patron(String name) {
		this.name = name;
		this.id = pId++;
		this.joiningDate = null;
		this.lending = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public List<Lending> getLending() {
		return lending;
	}

	public void setLending(List<Lending> lending) {
		this.lending = lending;
	}
	
}
