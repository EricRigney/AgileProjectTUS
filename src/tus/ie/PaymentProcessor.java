package tus.ie;

import java.util.List;

public class PaymentProcessor {

	private static final double NORTH_SOUTH_PRICE = 50.00;
	private static final double EAST_WEST_PRICE = 100.00;
	private static final double VIP_EXTRA = 50.00;

	public double calculateTotal(List<String> selectedSeats, boolean vip) {
		
		if (selectedSeats == null || selectedSeats.isEmpty()) {
			throw new IllegalArgumentException("No seats selected.");
		}
		
		double total = 0;
		
		for(String seat : selectedSeats) {
			total += calculateTicketPrice(seat, vip);
		}
		
		return total;
	}
		
	private double calculateTicketPrice(String seat, boolean vip) {
		
	
		if (seat == null || seat.trim().isEmpty()) {
			throw new IllegalArgumentException("Invalid seat");

		}
		
		String [] details = seat.split("-");
		
		if(details.length != 3) {
			throw new IllegalArgumentException("Invalid seat format.");
		}
		
		double price;
		
		switch (details[0]) {
		case "North":
		case "South":
			price = NORTH_SOUTH_PRICE;
			break;
			
		case "East":
		case "West":
			price = EAST_WEST_PRICE;
			break;
	
			default:
				throw new IllegalArgumentException("Invalid stand.");
		}
		
		if (vip) {
			price += VIP_EXTRA;
		}
		
	return price;
}

}
