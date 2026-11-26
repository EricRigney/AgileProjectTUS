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
		
		if (seat == null || seat.trim().isEmpty()) {
			throw new IllegalArgumentException("Invalid seat");

		}
		
		String [] details = seat.split("-");
		
		if(details.length != 3) {
			throw new IllegalArgumentException("Invalid seat format.");
		}
		
		String stand = details[0];
		double price;
		
		switch (stand) {
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
		
		total += price;
	
	}
	return total;
}

}
