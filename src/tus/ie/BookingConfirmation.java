package tus.ie;

import java.util.List;
import java.util.UUID;

public class BookingConfirmation {

	private String bookingReference;
	private String eventName;
	private String eventDate;
	private List<String> seats;
	private double totalCost;

	public BookingConfirmation(String eventName, String eventDate, List<String> seats, double totalCost) {

		this.bookingReference = "EP-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();

		this.eventName = eventName;
		this.eventDate = eventDate;
		this.seats = List.copyOf(seats);
		this.totalCost = totalCost;

	}
	
	public String getBookingReference() {
		return bookingReference;
	}
}
