package tus.ie;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class BookingConfirmationTest {

	@Test
	public void testBookingReferenceIsGenerated() {

		BookingConfirmation confirmation = new BookingConfirmation("All Ireland Final", "15/08/2027",
				Arrays.asList("North-A-1"), 50.00);

		assertNotNull(confirmation.getBookingReference());

		assertTrue(confirmation.getBookingReference().matches("EP-[A-F0-9]{8}"));

	}

	@Test
	public void testConfirmationContainsEventDetails() {

		BookingConfirmation confirmation = new BookingConfirmation("All Ireland Final", "15/08/2027",
				Arrays.asList("North-A-1"), 50.00);

		String result = confirmation.generateConfirmation();

		assertTrue(result.contains("All Ireland Final"));
		assertTrue(result.contains("15/08/2027"));
		assertTrue(result.contains("Booking Reference:"));
		assertTrue(result.contains("Ticket Quantity: 1"));

	}

	@Test
	public void testConfirmationContainsTicketDetails() {

		BookingConfirmation confirmation = new BookingConfirmation("All Ireland Final", "15/08/2027",
				Arrays.asList("North-A-1"), 50.00);

		String result = confirmation.generateConfirmation();

		assertTrue(result.contains("DIGITAL TICKETS"));
		assertTrue(result.contains("Seat: North-A-1"));
		assertTrue(result.contains("Gate: Gate 1"));

	}

	@Test
	public void testMultipleTicketsAreDisplayed() {

		BookingConfirmation confirmation = new BookingConfirmation("All Ireland Final", "15/08/2027",
				Arrays.asList("North-A-1", "South-B-2"), 100.00);

		String result = confirmation.generateConfirmation();

		assertTrue(result.contains("Ticket Quantity: 2"));
		assertTrue(result.contains("Seat: North-A-1"));
		assertTrue(result.contains("Seat: South-B-2"));
		assertTrue(result.contains("Gate: Gate 1"));
		assertTrue(result.contains("Gate: Gate 2"));

	}
	@Test
	public void testTotalCostIsDisplayed() {

		BookingConfirmation confirmation = new BookingConfirmation("All Ireland Final", "15/08/2027",
				Arrays.asList("East-A-1"), 100.00);

		String result = confirmation.generateConfirmation();

		assertTrue(result.contains("100.00"));

	}
	@Test
	public void testThankYouIsDisplayed() {

		BookingConfirmation confirmation = new BookingConfirmation("All Ireland Final", "15/08/2027",
				Arrays.asList("West-A-1"), 100.00);

		String result = confirmation.generateConfirmation();

		assertTrue(result.contains("Thank you for booking with EventPass!"));

	}

}
