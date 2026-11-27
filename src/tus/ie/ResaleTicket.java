package tus.ie;

import java.util.UUID;

public class ResaleTicket {

	private String ticketID;
	private String eventName;
	private String eventDate;
	private String seatID;
	private double originalPrice;
	private String ownerUsername;
	private boolean availableForResale;
	
	public ResaleTicket( String eventName, String eventDate, String seatID, double originalPrice, String ownerUsername, boolean availableForResale) {
		
		this.ticketID = "TKT-" + UUID.randomUUID().toString().substring(0,8).toUpperCase();
		
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.seatID = seatID;
		this.originalPrice = originalPrice;
		this.ownerUsername = ownerUsername;
		this.availableForResale = availableForResale;
	}
	
	public ResaleTicket(String ticketID, String eventName, String eventDate, String seatID, double originalPrice, String ownerUsername, boolean availableForResale) {

		this.ticketID = ticketID;
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.seatID = seatID;
		this.originalPrice = originalPrice;
		this.ownerUsername = ownerUsername;
		this.availableForResale = availableForResale;
	}

	public String getTicketID() {
		return ticketID;
	}

	public String getEventName() {
		return eventName;
	}

	public String getEventDate() {
		return eventDate;
	}

	public String getSeatID() {
		return seatID;
	}

	public double getOriginalPrice() {
		return originalPrice;
	}

	public String getOwnerUsername() {
		return ownerUsername;
	}

	public boolean getAvailableForResale() {
		return availableForResale;
	}

	public void listForResale(double resalePrice) {

		if (resalePrice != originalPrice) {
			throw new IllegalArgumentException("Resale price must equal the original ticket price.");
		}

		availableForResale = true;
	}

	public boolean purchaseResaleTicket(String newOwnerUsername) {

		if (!availableForResale || newOwnerUsername == null || newOwnerUsername.trim().isEmpty()
				|| newOwnerUsername.equals(ownerUsername)) {
			return false;
		}

		ownerUsername = newOwnerUsername;
		availableForResale = false;

		return true;
	}
}
