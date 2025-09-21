package entity;

import java.util.Date;

public class Lending {
	
	public static int id = 1;

	private int LendingID;
	private Book book;
	private Patron patron;
	private Date checkoutDate;
	private Date dueDate;
	private Date returnDate;
	
	
	public Lending(int lendingID, Book book, Patron patron) {
		this.LendingID = lendingID;
		this.book = book;
		this.patron = patron;
		this.checkoutDate = new Date();
		this.dueDate = new Date();
		this.returnDate = null;
	}

	public int getLendingID() {
		return LendingID;
	}

	public Book getBook() {
		return book;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}


	public Patron getPatron() {
		return patron;
	}


	public Date getReturnDate() {
		return returnDate;
	}


	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
}
