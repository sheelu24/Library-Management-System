package service;

import java.util.HashMap;
import java.util.Map;

import entity.Book;
import entity.Patron;
import entity.Reservation;

public class ReservationService {
	
	public static Map<Book,Reservation> reservationRecord = new HashMap();

	//reserve book
		public void reserveBook(Book book , Patron patron) {
			
			if(reservationRecord.containsKey(book)) {
				Reservation reserve = new Reservation(Reservation.id++,book,patron);
				reservationRecord.put(book, reserve);
				System.out.println(" Book " + book.getTitle() + " reservation complete ");
			}else {
				System.out.println(" Book " + book.getTitle() + " already reserved ");
			}
		}
		// cancel book reserve
		public  void CancelReserve( Book book , Patron patron) {
			
			if(reservationRecord.containsKey(book)) {
				System.out.println(" Book " + book.getTitle() + " is not reserved");
			}else if( reservationRecord.get(book).getPatron().getId() != patron.getId() ) {
				System.out.println(" Only the patron who reserved can cancel ");
			}else {
				reservationRecord.remove(book);
				System.out.println(" Book " + book.getTitle() + " reservation cancelled ");
			}
			
		}	
}
