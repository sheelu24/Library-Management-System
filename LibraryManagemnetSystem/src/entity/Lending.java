package entity;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Lending {
	
	static int id = 1;

	private int LendingID;
	private Book book;
	private Patron Patron;
	private Date checkoutDate;
	private Date dueDate;
	private Date returnDate;
	
	public Lending(int lendingID, Book book, Patron Patron) {
		this.LendingID = lendingID;
		this.book = book;
		this.Patron = Patron;
		this.checkoutDate = new Date();
		this.dueDate = new Date();
		this.returnDate = null;
	}

	public int getLendingID() {
		return LendingID;
	}
	
	public void setLendingID(int LendingID) {
		this.LendingID = LendingID;
	}
	
	public Book getBook() {
		return book;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}
	
	public Patron getPatron() {
		return Patron;
	}
	
	public void setPatron(Patron Patron) {
		this.Patron = Patron;
	}
	
	public Date getCheckoutDate() {
		return checkoutDate;
	}
	
	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	
	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}
	
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	//lend book
	public static void lendBook(Book book , Patron patron) {
		
		if(book.getStatus()) {
			if(book.getReserve() != null && book.getReserve().getPatron().getId() != patron.getId()) {
				System.out.println(" Book " + book.getTitle() + " reserved by another patron ");
			}else {
				List<Lending> lendings = patron.getLending();
				lendings.add(new Lending(id++,book,patron));
				patron.setLending(lendings);
				book.setStatus(false);
				book.setReserve(null);
				System.out.println(" Book " + book.getTitle() + " checkout complete ");
			}
		}else {
			System.out.println(" Book " + book.getTitle() + " borrowed by another patron ");
		}
	}
	//return book
	public static void returnBook( Book book, Patron patron) {
		
		List<Lending> lendings = patron.getLending();
		Lending lend = null;
		for( Lending l : lendings) {
			if(l.getBook().getIsbn() == book.getIsbn() && l.getReturnDate() == null ) {
				lend = l;
				lendings.remove(l);
				break;
			}
		}
		
		if(lend == null ) {
			System.out.println(" Only the patron who borrowed can return ");
		}else {
			lend.setReturnDate(new Date());
			lendings.add(lend);
			patron.setLending(lendings);
			book.setStatus(true);
			if(book.getReserve() != null ) {
				System.out.println(" Patron " + book.getReserve().getPatron().getName() +" reserved book is available");
			}
		}
	}
	
	
}
