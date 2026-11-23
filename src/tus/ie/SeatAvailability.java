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
		if (availableSeats.contains(seat)) {
			availableSeats.remove(seat);
			return true;
		}
		return false;
	}

	public void loadSampleSeats() {

		String[] stands = { "North", "South", "East", "West" };

		for (String stand : stands) {
			for (char row = 'A'; row <= 'Z'; row++) {
				for (int seatNumber = 1; seatNumber <= 20; seatNumber++) {

					String seat = stand + "-" + row + "-" + seatNumber;

					availableSeats.add(seat);
				}
			}
		}
	}

	public ArrayList<String> getSeatsByStand(String stand) {

		ArrayList<String> standSeats = new ArrayList<>();

		for (String seat : availableSeats) {

			if (seat.startsWith(stand + "")) {
				standSeats.add(seat);
			}
		}
		return standSeats;
	}
}
