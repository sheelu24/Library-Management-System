package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import service.LendingService;
import service.ReservationService;

public class Library {
	
	private List<Branch> branches;
	private List<Patron> patrons;
	
	ReservationService reservationService = new ReservationService();
	LendingService lendingService = new LendingService();
	
	public Library() {
		this.branches = new ArrayList<>();
		this.patrons = new ArrayList<>();
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
	
	//add book
	//remove book
	//transfer book
	//search book
	
	//Add book
	public void addBook(Branch branch, Book book) {
		branch.addBook(book);
	}
	//Remove book
	public void removeBook(Branch branch, Book book) {
		branch.removeBook(book);
	}
	//Search
	public List<Book> serachTitleBook(Branch branch, String title) {
		return branch.serachTitleBook(title);
	}
		
	public List<Book> serachAuthorBook(Branch branch, String author) {
		return branch.serachAuthorBook(author);
	}
		
	public Optional<Book> serachIsbnBook(Branch branch, String isbn) {
		return branch.serachIsbnBook(isbn);
	}
	//Transfer
	public void transferBook(Book book, Branch branch1, Branch branch2) {
		
		branch1.removeBook(book);
		branch2.addBook(book);
		System.out.println(" Book " + book.getTitle() + " transfered successfully");
	}
	
	//lend book
	public void lendBook(Book book , Patron patron) {
		lendingService.lendBook(patron, book);
	}
	//return book
	public void returnBook( Book book, Patron patron) {
		lendingService.returnBook(book, patron);
	}
	
	//reserve book
	public void reserveBook(Book book , Patron patron) {
		reservationService.reserveBook(book, patron);
	}
	// cancel book reserve
	public void CancelReserve( Book book , Patron patron) {
		reservationService.CancelReserve(book, patron);
	}

}
