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
	}

	// Style Label
	private void styleLabel(JLabel style) {
		style.setFont(new Font("SansSerif", Font.BOLD, 13));
		style.setForeground(NAVY);
		style.setAlignmentX(Component.LEFT_ALIGNMENT);
	}
}
