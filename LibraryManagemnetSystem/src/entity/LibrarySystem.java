package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LibrarySystem {
	
	private String name;
	private List<Branch> branches;
	private List<Patron> patrons;
	
	public LibrarySystem(String name) {
		super();
		this.name = name;
		this.branches = new ArrayList<>();
		this.patrons = new ArrayList<>();
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Branch> getBranches() {
		return branches;
	}
	
	public void setBranches(List<Branch> branch) {
		this.branches = branch;
	}
	
	public List<Patron> getPatron() {
		return patrons;
	}
	
	public void setPatrons(List<Patron> Patrons) {
		this.patrons = Patrons;
	}
	
	public void addPatrons(Patron patron) {
		patron.setJoiningDate(new Date());
		this.patrons.add(patron);
		System.out.println(" Patron " + patron.getName() + " added successfully");
	}
	
	public void removePatrons(Patron patron) {
		this.patrons.remove(patron);
		System.out.println(" Patron " + patron.getName() + " removed successfully");
	}
	
	public void addBranch(Branch branch) {
		this.branches.add(branch);
		System.out.println(" Branch " + branch.getName() + " added successfully");
	}
	
	public void removeBranch(Branch branch) {
		this.branches.remove(branch);
		System.out.println(" Branch " + branch.getName() + " removed successfully");
	}
	

}
