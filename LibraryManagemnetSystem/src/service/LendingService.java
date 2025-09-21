package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.Book;
import entity.BookStatus;
import entity.Lending;
import entity.Patron;

public class LendingService {
	
	public static Map<Patron,List<Lending>> lendingRecord = new HashMap<Patron, List<Lending>>();

	//lend book
		public void lendBook(Patron patron , Book book) {
			if(!book.getStatus().equalsIgnoreCase("Availale")) {
				System.out.println(" Book " + book.getTitle() + " borrowed by another patron ");
				return;
			}
				
			if(book.getStatus().equalsIgnoreCase("Reserved") 
					&& !ReservationService.reservationRecord.get(book).getPatron().equals(patron)) {
				System.out.println(" Book " + book.getTitle() + " reserved by another patron ");
				return;
			}

			List<Lending> lendings = new ArrayList<>();
			if(lendingRecord.containsKey(patron)){
				lendings = lendingRecord.get(patron);
			}
			lendings.add(new Lending(Lending.id++,book,patron));
			book.setStatus(BookStatus.Lended);
			lendingRecord.put(patron, lendings);
			System.out.println(" Book " + book.getTitle() + " checkout complete ");
		}

		//return book
		public void returnBook( Book book, Patron patron) {
			
			List<Lending> lendings = new ArrayList<>();
			if(lendingRecord.containsKey(patron)){
				lendings = lendingRecord.get(patron);
			}
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
				lendingRecord.put(patron, lendings);
				if(ReservationService.reservationRecord.containsKey(book) ) {
					System.out.println(" Patron " + ReservationService.reservationRecord.get(book).getPatron().getName() +" reserved book is available");
				}
			}
		}
}
