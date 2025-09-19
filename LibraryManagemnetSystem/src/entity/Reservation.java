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
	//reserve book
	public static void reserveBook(Book book , Patron patron) {
		
		if(book.getReserve() == null) {
			Reservation reserve = new Reservation(id++,book,patron);
			book.setReserve(reserve);
			System.out.println(" Book " + book.getTitle() + " reservation complete ");
		}else {
			System.out.println(" Book " + book.getTitle() + " already reserved ");
		}
	}
	// cancel book reserve
	public static void CancelReserve( Book book , Patron patron) {
		
		if(book.getReserve() == null) {
			System.out.println(" Book " + book.getTitle() + " is not reserved");
		}else if( book.getReserve().getPatron().getId() != patron.getId() ) {
			System.out.println(" Only the patron who reserved can cancel ");
		}else {
			book.setReserve(null);
			System.out.println(" Book " + book.getTitle() + " reservation cancelled ");
		}
		
	}
	
}
