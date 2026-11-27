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

}
