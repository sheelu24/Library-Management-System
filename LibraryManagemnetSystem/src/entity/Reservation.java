package entity;

public class Reservation {
	
	public static int id = 0;
	
	private int ReserveID;
	private Book book;
	private Patron patron;
	
	public Reservation(int reserveID, Book book, Patron patron) {
		this.ReserveID = reserveID;
		this.book = book;
		this.patron = patron;
	}

	public int getReserveID() {
		return ReserveID;
	}
	
	public void setReserveID(int reserveID) {
		ReserveID = reserveID;
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
	
	public void setPatron(Patron patron) {
		this.patron = patron;
	}
}
