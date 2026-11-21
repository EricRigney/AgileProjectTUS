package tus.ie;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventSelectionGUI extends JFrame {

	private JComboBox<String> eventComboBox;
	private JSpinner dateSpinner;
	private JButton searchButton;

	private final Color NAVY = new Color(18, 32, 58);
	private final Color BLUE = new Color(45, 105, 230);
	private final Color LIGHT = new Color(245, 247, 252);
	private final Color GREY = new Color(105, 116, 135);

	public EventSelectionGUI() {

		setTitle("EventPass -Find Tickets");
		setSize(600, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		// Event Panel
		JPanel eventPanel = new JPanel(new BorderLayout());
		eventPanel.setBackground(LIGHT);

		// Event Header
		JPanel event = new JPanel();
		event.setLayout(new BoxLayout(event, BoxLayout.Y_AXIS));
		event.setBackground(NAVY);
		event.setBorder(new EmptyBorder(30, 20, 30, 20));

		JLabel logo = new JLabel("EVENT PASS");
		logo.setFont(new Font("SansSerif", Font.BOLD, 30));
		logo.setForeground(Color.WHITE);
		logo.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel subtitle = new JLabel("Find Your Next Event");
		subtitle.setFont(new Font("SanSerif", Font.PLAIN, 14));
		subtitle.setForeground(new Color(195, 207, 225));
		subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

		event.add(logo);
		event.add(Box.createVerticalStrut(10));
		event.add(subtitle);

		// Selection Card
		JPanel selectionCard = new JPanel();
		selectionCard.setLayout(new BoxLayout(event, BoxLayout.Y_AXIS));
		selectionCard.setBackground(Color.WHITE);
		selectionCard.setBorder(new EmptyBorder(30, 40, 30, 40));

		JLabel selection = new JLabel("Search for Tickets");
		selection.setFont(new Font("SanSerif", Font.BOLD, 24));
		selection.setForeground(NAVY);
		selection.setAlignmentX(Component.LEFT_ALIGNMENT);

		JLabel description = new JLabel(" Select an event and date to get started.");
		description.setFont(new Font("SanSerif", Font.PLAIN, 13));
		description.setForeground(GREY);
		description.setAlignmentX(Component.LEFT_ALIGNMENT);

		// Event Label
		JLabel eventLabel = new JLabel("Select Event");
		styleLabel(eventLabel);

		// Event Dropdown Option
		String[] events = { " Barcelona vs Real Madrid - La Liga", "Ireland vs England - Six Nations",
				"All Ireland Hurling Final", " Coldplay - Concert", "Taylor Swift - Concert" };
		
		eventComboBox = new JComboBox<>(events);
		eventComboBox.setFont(new Font("SansSerif", Font.PLAIN, 14));
		eventComboBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
		eventComboBox.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		// Date Label 
		JLabel dateLabel = new JLabel("Select Date");
		styleLabel(dateLabel);
		
		// Date spinner
		SpinnerDateModel dateModel = new SpinnerDateModel(new Date(), null, null, java.util.Calendar.DAY_OF_MONTH);
		
		dateSpinner = new JSpinner(dateModel);
		dateSpinner.setEditor(new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy"));
		dateSpinner.setFont(new Font("SansSerif", Font.PLAIN, 14));
		dateSpinner.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
		dateSpinner.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		// Search Button
		searchButton = new JButton("Search Available Seats");
		searchButton.setFont(new Font("SanSerif", Font.BOLD,15));
		searchButton.setBackground(Color.WHITE);
		searchButton.setForeground(BLUE);
		searchButton.setFocusPainted(false);
		searchButton.setBorderPainted(false);
		searchButton.setCursor( new Cursor(Cursor.HAND_CURSOR));
		searchButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		searchButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
		
		// Add Components
		selectionCard.add(selection);
		selectionCard.add(Box.createVerticalStrut(8));
		selectionCard.add(description);
		selectionCard.add(Box.createVerticalStrut(10));
		
		selectionCard.add(eventLabel);
		selectionCard.add(Box.createVerticalStrut(8));
		selectionCard.add(eventComboBox);
		selectionCard.add(Box.createVerticalStrut(20));
		
		selectionCard.add(dateLabel);
		selectionCard.add(Box.createVerticalStrut(8));
		selectionCard.add(dateSpinner);
		selectionCard.add(Box.createVerticalStrut(30));
		
		// Card Container
		JPanel cardContainer = new JPanel(new BorderLayout());
		cardContainer.setBackground(LIGHT);
		cardContainer.setBorder(new EmptyBorder(20,40,40,40));
		cardContainer.add(selectionCard, BorderLayout.CENTER);
		
		eventPanel.add(event, BorderLayout.NORTH);
		eventPanel.add(cardContainer, BorderLayout.CENTER);
		
		add(eventPanel);
		
		// Button Action
		searchButton.addActionListener(e -> searchEvent());
		
	}

	// Style Label
	private void styleLabel(JLabel style) {
		style.setFont(new Font("SansSerif", Font.BOLD, 13));
		style.setForeground(NAVY);
		style.setAlignmentX(Component.LEFT_ALIGNMENT);
	}
	
	// Search Label
	private void searchEvent() {
		
		String selectedEvent = (String) eventComboBox.getSelectedItem();
		Date selectedDate = (Date) dateSpinner.getValue();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = dateFormat.format(selectedDate);
		
		JOptionPane.showMessageDialog(this, "Event: " + selectedEvent + "\nDate: " + formattedDate + "\n\nSearching for available seats...", "Ecebt Selected", JOptionPane.INFORMATION_MESSAGE);
		
	}
}
