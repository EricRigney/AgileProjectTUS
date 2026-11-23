package tus.ie;

import java.util.ArrayList;

public class SeatAvailability {
	
	private ArrayList<String> availableSeats;
	
	public SeatAvailability() {
		availableSeats = new ArrayList<>();
	}
	
	public void addSeat(String seat) {
		availableSeats.add(seat);
	}
	
	public ArrayList<String> getAvailableSeats() {
		return availableSeats;
	}
}
