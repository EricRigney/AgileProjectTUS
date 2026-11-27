package tus.ie;

import java.util.ArrayList;
import java.io.*;

public class TicketManager {

	private ArrayList<ResaleTicket> tickets;

	private final String FILE_NAME = "tickets.txt";

	public TicketManager() {
		tickets = new ArrayList<>();
		loadTickets();
	}

	// Add a newly purchased ticket
	public void addTicket(ResaleTicket ticket) {
		tickets.add(ticket);
		saveTickets();
	}

	// Get all tickets owned by a user

	public ArrayList<ResaleTicket> getUserTickets(String username) {

		ArrayList<ResaleTicket> userTickets = new ArrayList<>();

		for (ResaleTicket ticket : tickets) {
			if (ticket.getOwnerUsername().equals(username)) {
				userTickets.add(ticket);
			}
		}

		return userTickets;
	}

	// Get all tickets available for resale
	public ArrayList<ResaleTicket> getResaleTickets() {

		ArrayList<ResaleTicket> resaleTickets = new ArrayList<>();

		for (ResaleTicket ticket : tickets) {
			if (ticket.isAvailableForResale()) {
				resaleTickets.add(ticket);
			}
		}
		
		return resaleTickets;
	}

}
