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
	
	public String generateConfirmation() {
		
		StringBuilder confirmation = new StringBuilder();
		
		confirmation.append("EventPass - BOOKING CONFIRMATION\n\n");
		confirmation.append("Bookinhg Reference: ").append("bookingReference: ").append(bookingReference).append("\n\n");
		
		confirmation.append("Event: ").append(eventName).append("\n");
		confirmation.append("Date: ").append(eventDate).append("\n");
		confirmation.append("Ticket Quantity: ").append(seats.size()).append("\n");
		confirmation.append("Total Cost: ").append(String.format("%.2f", totalCost)).append("\n\n");
		
		confirmation.append("DIGITAL TICKETS\n\n");
		
		for (String seat : seats) {
			
			confirmation.append("Seat: ").append(seat).append("\n");
			confirmation.append("Gate: ").append(getGateNumber(seat)).append("\n\n");
			
		}
		
		confirmation.append("Thnank you for booking with EventPass!");
		
		return confirmation.toString();


	}
	
	private String getGateNumber(String seat) {
		
		String stand = seat.split("-")[0];
		
		switch (stand) {
		case "North":
			return "Gate 1";
		case "South":
			return "Gate 2";
		case "East":
			return "Gate 3";
		case "West":
			return "Gate 4";
			default:
				return "Gate not assigned";
		}
	}
	
}
