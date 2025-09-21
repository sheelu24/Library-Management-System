package main;

import java.util.List;

import entity.Book;
import entity.Branch;
import entity.Library;
import entity.Patron;

public class LibrarySystem {

	public static void main(String[] args) {
		
		Library library = new Library();
				
		Branch branch1 = new Branch("lib", "banglore");
		library.addBranch(branch1);

		Book b1 = new Book("hello","123","jack");
		Book b2 = new Book("world","456","jack");
		library.addBook(branch1,b1);
		library.addBook(branch1,b2);
		System.out.println("------------------------");
		
		Patron p1 = new Patron("Sam");
		Patron p2 = new Patron("Rio");
		library.addPatrons(p1);
		library.addPatrons(p2);
		System.out.println("------------------------");
		
		library.lendBook(b1, p1); // completed
		library.lendBook(b1, p2); // book not available
		library.lendBook(b2, p2); // completed
		System.out.println("------------------------");
		
		library.reserveBook(b1, p2); // reserve book 
		library.reserveBook(b1, p1); // already reserved book
		//System.out.println(" reserve " + b1.getTitle() + " by " + b1.getReserve().getPatron().getName());
		System.out.println("------------------------");
		
		library.returnBook(b2, p2); // return book that patron doesn't have 
		library.returnBook(b1, p1); // return book
		//p1.getLending().forEach(l -> System.out.println(" book " + l.getBook().getTitle() + " returned on "+ l.getReturnDate() ));
		System.out.println("------------------------");
		
		library.lendBook(b1, p2); // get reserved book
		System.out.println("------------------------");
		
		Branch branch2 = new Branch("lib2", "pune");
		library.transferBook(b2, branch1, branch2); // transfer book
		branch1.getBooks().forEach(b -> System.out.println(" b1 book " + b.getTitle()));
		branch2.getBooks().forEach(b -> System.out.println(" b2 book " + b.getTitle()));
		System.out.println("------------------------");
		
		List<Book> foundBook = library.serachTitleBook(branch1, b2.getTitle()); // book present
		List<Book> notFoundBook = library.serachTitleBook(branch2, b1.getTitle()); // book not present
		System.out.println(" found " + foundBook.size() + "  not found " + notFoundBook.size() );
		System.out.println("------------------------");
		
	}
	
}
