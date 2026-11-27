package tus.ie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

public class SeatSelectionGUI extends JFrame {

	private SeatAvailability seatAvailability;

	private JComboBox<String> standComboBox;
	private JComboBox<String> rowComboBox;

	private JPanel seatsPanel;
	private JLabel selectionLabel;

	private ArrayList<String> selectedSeats;

	private JCheckBox vipCheckBox;
	private PaymentProcessor paymentProcessor = new PaymentProcessor();

	private String eventName;
	private String eventDate;
	private String loggedInUser;

	private final Color NAVY = new Color(18, 32, 58);
	private final Color GREEN = new Color(76, 175, 80);
	private final Color BLUE = new Color(45, 105, 230);
	private final Color GREY = new Color(180, 180, 180);
	private final Color LIGHT = new Color(245, 247, 252);

	public SeatSelectionGUI(String eventName, String eventDate, SeatAvailability seatAvailability, String loggedInUser) {

		this.eventName = eventName;
		this.eventDate = eventDate;
		this.seatAvailability = seatAvailability;
		this.loggedInUser = loggedInUser;

		selectedSeats = new ArrayList<>();

		setTitle("EventPass - Seat Selection");
		setSize(850, 650);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		setLayout(new BorderLayout());

		// Header Panel
		JPanel headerPanel = new JPanel(new GridLayout(2, 1));
		headerPanel.setBackground(NAVY);
		headerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		JLabel titleLabel = new JLabel("EVENT PASS", SwingConstants.CENTER);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
		titleLabel.setForeground(Color.WHITE);

		JLabel eventLabel = new JLabel(eventName + " | " + eventDate, SwingConstants.CENTER);
		eventLabel.setFont(new Font("Arial", Font.BOLD, 15));
		eventLabel.setForeground(Color.WHITE);

		headerPanel.add(titleLabel);
		headerPanel.add(eventLabel);

		add(headerPanel, BorderLayout.NORTH);

		// Main Panel
		JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
		mainPanel.setBackground(LIGHT);
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		// Control Panel
		JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 15));
		controlPanel.setBackground(LIGHT);

		standComboBox = new JComboBox<>(new String[] { "North", "South", "East", "West" });

		rowComboBox = new JComboBox<>();

		for (char row = 'A'; row <= 'Z'; row++) {
			rowComboBox.addItem(String.valueOf(row));
		}

		controlPanel.add(new JLabel("Select Stand"));
		controlPanel.add(standComboBox);

		controlPanel.add(new JLabel("Select row"));
		controlPanel.add(rowComboBox);

		vipCheckBox = new JCheckBox("VIP (+ 50 euro per ticket");
		vipCheckBox.setBackground(LIGHT);
		
		controlPanel.add(vipCheckBox);

		mainPanel.add(controlPanel, BorderLayout.NORTH);

		// Seats Panel
		seatsPanel = new JPanel(new GridLayout(4, 5, 10, 10));
		seatsPanel.setBackground(Color.WHITE);
		seatsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		JScrollPane scrollPane = new JScrollPane(seatsPanel);
		scrollPane.setBorder(BorderFactory.createLineBorder(GREY));

		mainPanel.add(scrollPane, BorderLayout.CENTER);

		// Bottom Panel
		JPanel bottomPanel = new JPanel(new BorderLayout());
		bottomPanel.setBackground(LIGHT);
		bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

		selectionLabel = new JLabel("Selected seats: 0");
		selectionLabel.setFont(new Font("Arial", Font.BOLD, 16));

		JButton bookButton = new JButton("Book Selected Seats");
		bookButton.setFont(new Font("Arial", Font.BOLD, 16));
		bookButton.setForeground(BLUE);

		bottomPanel.add(selectionLabel, BorderLayout.WEST);
		bottomPanel.add(bookButton, BorderLayout.EAST);

		mainPanel.add(bottomPanel, BorderLayout.SOUTH);

		add(mainPanel, BorderLayout.CENTER);

		// Event Listeners
		standComboBox.addActionListener(e -> updateSeats());
		rowComboBox.addActionListener(e -> updateSeats());
		bookButton.addActionListener(e -> bookSelectedSeats());

		updateSeats();
	}

	// Update Seats
	private void updateSeats() {

		seatsPanel.removeAll();

		String stand = (String) standComboBox.getSelectedItem();
		String row = (String) rowComboBox.getSelectedItem();

		if (stand == null || row == null) {
			return;
		}

		for (int seatNumber = 1; seatNumber <= 20; seatNumber++) {

			String seatID = stand + "-" + row + "-" + seatNumber;

			JButton seatButton = new JButton(String.valueOf(seatNumber));
			seatButton.setFont(new Font("Arial", Font.BOLD, 12));
			seatButton.setFocusPainted(false);

			if (selectedSeats.contains(seatID)) {

				seatButton.setBackground(BLUE);
				seatButton.setForeground(Color.WHITE);

			} else if (seatAvailability.isSeatAvailable(seatID)) {

				seatButton.setBackground(GREEN);
				seatButton.setForeground(Color.WHITE);

			} else {

				seatButton.setBackground(GREY);
				seatButton.setForeground(Color.WHITE);
				seatButton.setEnabled(false);
			}

			seatButton.addActionListener(e -> {

				if (selectedSeats.contains(seatID)) {
					selectedSeats.remove(seatID);
				} else {
					selectedSeats.add(seatID);
				}

				updateSeats();
				updateSelectionLabel();
			});

			seatsPanel.add(seatButton);
		}

		seatsPanel.revalidate();
		seatsPanel.repaint();

		updateSelectionLabel();
	}

	private void updateSelectionLabel() {

		selectionLabel.setText("Selected seats: " + selectedSeats.size());

	}

	// Booking Selected Seats
	private void bookSelectedSeats() {

		if (selectedSeats.isEmpty()) {

			JOptionPane.showMessageDialog(this, "Pleases select at least one seat", "No Seats Selected",
					JOptionPane.WARNING_MESSAGE);

			return;
		}

		// Calculate the ticket price
		boolean vip = vipCheckBox.isSelected();

		double total = paymentProcessor.calculateTotal(selectedSeats, vip);

		// Check that all selected seats are still available
		for (String seat : selectedSeats) {

			if (!seatAvailability.isSeatAvailable(seat)) {

				JOptionPane.showMessageDialog(this, "Sorry, seat" + seat + " is no longer available",
						"Seat Unavailable", JOptionPane.WARNING_MESSAGE);

				updateSeats();
				return;
			}
		}

		// Display payment confirmation
		String message = "Booking Details\n\n" + "Event:" + eventName + "\n" + "Date:" + eventDate + "\n" + "Seats:"
				+ selectedSeats + "\n" + "Ticket Type:" + (vip ? "VIP" : "Standard") + "\n\n" + "Total Cost: "
				+ String.format("%.2f", total) + "\n" + "Current Balance: "
				+ String.format("%.2f", paymentProcessor.getBalance()) + "\n\nConfirm Payment?";

		int confirm = JOptionPane.showConfirmDialog(this, message, "Confrim Payment", JOptionPane.YES_NO_CANCEL_OPTION);

		if (confirm != JOptionPane.YES_OPTION) {
			return;
		}

		// Process Payment
		boolean paymentSuccessful = paymentProcessor.processPayment(total);

		if (!paymentSuccessful) {

			JOptionPane.showMessageDialog(this,
					"Payment declined! Insufficent balance.\n" + "Your current balance is "
							+ String.format("%.2f", paymentProcessor.getBalance()),
					"Payment Failed", JOptionPane.ERROR_MESSAGE);

			return;
		}

		// Book seats after successful payment
		int bookedCount = 0;

		for (String seat : selectedSeats) {

			if (seatAvailability.bookSeat(seat)) {
				bookedCount++;
			}
		}

		// Generate Booking Confirmation
		if (bookedCount == selectedSeats.size()) {
			BookingConfirmation confirmation = new BookingConfirmation(eventName, eventDate, selectedSeats, total);

			String confirmationDetails = confirmation.generateConfirmation();

			JOptionPane.showMessageDialog(this,
					confirmationDetails + "\n\nRemaining Balance: "
							+ String.format("%.2f", paymentProcessor.getBalance()),
					"Booking Confirmation - " + confirmation.getBookingReference(), JOptionPane.INFORMATION_MESSAGE);
		} else {

			JOptionPane.showMessageDialog(this,
					bookedCount + "of" + selectedSeats.size() + " seats were booked. "
							+ " Please contract support regarding " + " the incomplete booking -",
					"Booking Issue", JOptionPane.WARNING_MESSAGE);
		}

		selectedSeats.clear();
		updateSeats();

		vipCheckBox.setSelected(false);
	}

}
