package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Branch {
	
	static int id = 1;

	private int branchID;
	private String name;
	private String address;
	private List<Book> books;
	
	public Branch( String name, String address) {
		this.branchID = id;
		this.name = name;
		this.address = address;
		this.books = new ArrayList<>();
	}

	public int getBranchID() {
		return branchID;
	}
	
	public void setBranchID(int branchID) {
		this.branchID = branchID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public List<Book> getBooks() {
		return books;
	}
	
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	//Add book
	public void addBook(Book book) {
		this.books.add(book);
		System.out.println(" Book " + book.getTitle() + " added successfully");
	}
	//Remove book
	public void removeBook(Book book) {
		this.books.remove(book);
		System.out.println(" Book " + book.getTitle() + " removed successfully");
	}
	//Search
	public List<Book> serachTitleBook(String title) {
		return this.books.stream()
				.filter(b -> b.getTitle().equalsIgnoreCase(title))
				.collect(Collectors.toList());
	}
	
	public List<Book> serachAuthorBook(String author) {
		return this.books.stream()
				.filter(b -> b.getAuthor().equalsIgnoreCase(author))
				.collect(Collectors.toList());
	}
	
	public Optional<Book> serachIsbnBook(String isbn) {
		return this.books.stream()
				.filter(b -> b.getIsbn().equalsIgnoreCase(isbn))
				.findFirst();
	}
}
