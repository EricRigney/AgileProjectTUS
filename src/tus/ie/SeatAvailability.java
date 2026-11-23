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
	
	public boolean isSeatAvailable(String seat) {
		return availableSeats.contains(seat);
	}
	
	public boolean bookSeat(String seat) {
		if(availableSeats.contains(seat)) {
			availableSeats.remove(seat);
			return true;
		}
		return false;
	}
}
