package entity;


public class Book {
	
	private String title;
	private String isbn;
	private String author;
	private Boolean status;//borrowed
	private Reservation reserve;//reserved
	
	public Book(String title, String isbn, String author) {
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.status = true;
		this.reserve = null;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public Boolean getStatus() {
		return status;
	}
	
	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Reservation getReserve() {
		return reserve;
	}

	public void setReserve(Reservation reserve) {
		this.reserve = reserve;
	}

}
