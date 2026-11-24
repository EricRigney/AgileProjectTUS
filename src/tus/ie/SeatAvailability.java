package tus.ie;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SeatAvailability {

	private ArrayList<String> availableSeats;

	private final String FILE_NAME = "bookedSeats.txt";

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

			try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {

				writer.write(seat);
				writer.newLine();

				return true;

			} catch (IOException e) {

				e.printStackTrace();

				// Restore seat if saving fails
				availableSeats.add(seat);

				return false;
			}

		}
		return false;
	}

	// Load Sample Stadium Seats
	public void loadSampleSeats() {

		String[] stands = { "North", "South", "East", "West" };

		availableSeats.clear();

		for (String stand : stands) {
			for (char row = 'A'; row <= 'Z'; row++) {
				for (int seatNumber = 1; seatNumber <= 20; seatNumber++) {

					String seat = stand + "-" + row + "-" + seatNumber;

					availableSeats.add(seat);
				}
			}
		}

		// Load previously Booked Seats
		loadBookedSeats();
	}
	
	// Load Booked Seats From File
	private void loadBookedSeats() {
		
		try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
			
			String seat;
			
			while((seat = reader.readLine()) != null) {
				availableSeats.remove(seat);
			}
			
		} catch (IOException e) {
			
			// File does not Exist
			System.out.println("No previous booking found.");
		}
	}

	public ArrayList<String> getSeatsByStand(String stand) {

		ArrayList<String> standSeats = new ArrayList<>();

		for (String seat : availableSeats) {

			if (seat.startsWith(stand + "-")) {
				standSeats.add(seat);
			}
		}
		return standSeats;
	}
	
	// Test Stadium 
	public static void main(String[] args) {

		SeatAvailability stadium = new SeatAvailability();
		stadium.loadSampleSeats();
		
		System.out.println(" Total available Seats: " + stadium.getAvailableSeats().size());
		System.out.println(" North Stand Seats: " + stadium.getSeatsByStand("North").size());
		System.out.println(" South Stand Seats: " + stadium.getSeatsByStand("South").size());
		System.out.println(" East Stand Seats: " + stadium.getSeatsByStand("East").size());
		System.out.println(" West Stand Seats: " + stadium.getSeatsByStand("West").size());

	}
}
