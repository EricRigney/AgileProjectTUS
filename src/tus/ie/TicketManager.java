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
			if (ticket.getAvailableForResale()) {
				resaleTickets.add(ticket);
			}
		}

		return resaleTickets;
	}

	// List a ticket for resale
	public boolean listTicket(String ticketID, String username, double resalePrice) {

		for (ResaleTicket ticket : tickets) {

			if (ticket.getTicketID().equals(ticketID) && ticket.getOwnerUsername().equals(username)) {

				ticket.listForResale(resalePrice);
				saveTickets();

				return true;
			}
		}

		return false;

	}

	// Purchase a resale ticket
	public boolean purchaseTicket(String ticketID, String newOwnerUsername) {

		for (ResaleTicket ticket : tickets) {

			if (ticket.getTicketID().equals(ticketID)) {

				boolean purchased = ticket.purchaseResaleTicket(newOwnerUsername);

				if (purchased) {
					saveTickets();
				}

				return purchased;
			}
		}

		return false;
	}

	// Save tickets to file
	private void saveTickets() {

		try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {

			for (ResaleTicket ticket : tickets) {

				writer.println(ticket.getTicketID() + "," + ticket.getEventName() + "," + ticket.getEventDate() + ","
						+ ticket.getSeatID() + "," + ticket.getOriginalPrice() + "," + ticket.getOwnerUsername() + ","
						+ ticket.getAvailableForResale());
			}

		} catch (IOException e) {
			System.out.println("Error saving tickets: " + e.getMessage());
		}
	}

	// Load tickets from file
	private void loadTickets() {

		File file = new File(FILE_NAME);

		if (!file.exists()) {
			return;
		}

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

			String line;

			while ((line = reader.readLine()) != null) {

				String[] details = line.split(",", -1);

				if (details.length == 7) {

					ResaleTicket ticket = new ResaleTicket(details[0], details[1], details[2], details[3],
							Double.parseDouble(details[4]), details[5], Boolean.parseBoolean(details[6]));

					tickets.add(ticket);
				}

			}

		} catch (IOException | NumberFormatException e) {
			System.out.println("Error loading tickets: " + e.getMessage());
		}
	}
}
