package tus.ie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class PaymentProcessorTest {

	@Test
	void testNorthStandTicketTotal() {

		// Arrange
		PaymentProcessor processor = new PaymentProcessor();

		// Act
		double total = processor.calculateTotal(Arrays.asList("North-A-1", "North-A-2"), false);

		// Assert
		assertEquals(100.00, total, 0.001);

	}

	@Test
	void testEastStandandTicketTotal() {

		// Arrange
		PaymentProcessor processor = new PaymentProcessor();

		// Act
		double total = processor.calculateTotal(Arrays.asList("East-A-1", "East-A-2"), false);

		// Assert
		assertEquals(200.00, total, 0.001);

	}

	@Test
	void testWestStandVIPTicketTotal() {

		// Arrange
		PaymentProcessor processor = new PaymentProcessor();

		// Act
		double total = processor.calculateTotal(Arrays.asList("West-B-1"), true);

		// Assert
		assertEquals(150.00, total, 0.001);

	}

	@Test
	void testSouthStandVIPTicketTotal() {

		// Arrange
		PaymentProcessor processor = new PaymentProcessor();

		// Act
		double total = processor.calculateTotal(Arrays.asList("South-C-1"), true);

		// Assert
		assertEquals(100.00, total, 0.001);

	}

	@Test
	void testStartingBalance() {

		// Arrange
		PaymentProcessor processor = new PaymentProcessor();

		// Act
		double balance = processor.getBalance();

		// Assert
		assertEquals(200.00, balance, 0.001);

	}

	@Test
	void testSuccessfulPayment() {

		// Arrange
		PaymentProcessor processor = new PaymentProcessor();

		// Act
		boolean result = processor.processPayment(100.00);

		// Assert
		assertEquals(true, result);
		assertEquals(100.00, processor.getBalance(), 0.001);

	}

	@Test
	void testInsufficentBalance() {

		// Arrange
		PaymentProcessor processor = new PaymentProcessor();

		// Act
		boolean result = processor.processPayment(250.00);

		// Assert
		assertEquals(false, result);
		assertEquals(200.00, processor.getBalance(), 0.001);

	}

}
