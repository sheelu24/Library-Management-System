package main;

import java.util.List;

import entity.Book;
import entity.Branch;
import entity.Lending;
import entity.LibrarySystem;
import entity.Patron;
import entity.Reservation;

public class RunLibrarySystem {

	public static void main(String[] args) {
		
		Book b1 = new Book("hello","123","jack");
		Book b2 = new Book("world","456","jack");
		
		Branch branch1 = new Branch("lib", "banglore");
		branch1.addBook(b1);
		branch1.addBook(b2);
		System.out.println("------------------------");
		
		LibrarySystem library = new LibrarySystem("public library");
		library.addBranch(branch1);
		System.out.println("------------------------");
		
		Patron p1 = new Patron("Sam");
		Patron p2 = new Patron("Rio");
		library.addPatrons(p1);
		library.addPatrons(p2);
		System.out.println("------------------------");
		
		Lending.lendBook(b1, p1); // completed
		Lending.lendBook(b1, p2); // book not available
		Lending.lendBook(b2, p2); // completed
		System.out.println("------------------------");
		
		Reservation.reserveBook(b1, p2); // reserve book 
		Reservation.reserveBook(b1, p1); // already reserved book
		System.out.println(" reserve " + b1.getTitle() + " by " + b1.getReserve().getPatron().getName());
		System.out.println("------------------------");
		
		Lending.returnBook(b2, p2); // return book that patron doesn't have 
		Lending.returnBook(b1, p1); // return book
		p1.getLending().forEach(l -> System.out.println(" book " + l.getBook().getTitle() + " returned on "+ l.getReturnDate() ));
		System.out.println("------------------------");
		
		Lending.lendBook(b1, p2); // get reserved book
		System.out.println("------------------------");
		
		Branch branch2 = new Branch("lib2", "pune");
		branch1.transferBook(b2, branch2); // transfer book
		branch1.getBooks().forEach(b -> System.out.println(" b1 book " + b.getTitle()));
		branch2.getBooks().forEach(b -> System.out.println(" b2 book " + b.getTitle()));
		System.out.println("------------------------");
		
		List<Book> foundBook = branch2.serachTitleBook(b2.getTitle()); // book present
		List<Book> notFoundBook = branch2.serachTitleBook(b1.getTitle()); // book not present
		System.out.println(" found " + foundBook.size() + "  not found " + notFoundBook.size() );
		System.out.println("------------------------");
		
	}
	
}
