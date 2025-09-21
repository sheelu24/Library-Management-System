package entity;


public class Book {
	
	private String title;
	private String isbn;
	private String author;
	private BookStatus status;
	
	public Book(String title, String isbn, String author) {
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.status = BookStatus.Availale;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getStatus() {
		return this.status.toString();
	}

	public void setStatus(BookStatus status) {
		this.status = status;
	}

	public String getTitle() {
		return this.title;
	}

	public String getAuthor() {
		return author;
	}

}
