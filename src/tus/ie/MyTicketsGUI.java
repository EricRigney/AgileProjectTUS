package tus.ie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;;

public class MyTicketsGUI extends JFrame {

	private String loggedInUser;
	private TicketManager ticketManager;

	private final Color NAVY = new Color(18, 32, 58);
	private final Color LIGHT = new Color(245, 247, 252);
	private final Color BLUE = new Color(45, 105, 230);

	public MyTicketsGUI(String loggedInUser) {
		
		this.loggedInUser = loggedInUser;
		ticketManager = new TicketManager();
		
		setTitle("EventPass - My Tickets");
		setSize(650, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setLayout(new BorderLayout());
		
		// Header
		JPanel headerPanel = new JPanel(new BorderLayout());
		headerPanel.setBackground(NAVY);
		headerPanel.setBorder(BorderFactory.createEmptyBorder(25, 20, 25, 20));
		
		JLabel titleLabel = new JLabel("MY TICKETS", SwingConstants.CENTER);
		titleLabel.setFont( new Font("Arial", Font.BOLD,28));
		titleLabel.setForeground(Color.WHITE);
		
		headerPanel.add(titleLabel, BorderLayout.CENTER);
		add(headerPanel, BorderLayout.NORTH);
		
		// Tickets List
		JPanel mainPanel = new JPanel(new BorderLayout(10,10));
		mainPanel.setBackground(LIGHT);
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		JLabel description = new JLabel("Your purchased EventPass tickets");
		description.setFont(new Font("Arial", Font.BOLD,16));
		
		DefaultListModel<String> ticketModel = new DefaultListModel<>();
		
		ArrayList<ResaleTicket> userTickets = ticketManager.getUserTickets(loggedInUser);
		
		for (ResaleTicket ticket : userTickets) {
			
			String ticketDetails = "Ticket ID: " + ticket.getTicketID() + " | Event: " + ticket.getEventName() + " | Date: " + ticket.getEventDate() + " | Seat: " + ticket.getSeatID() + " | Price:" + String.format("%.2f", ticket.getOriginalPrice()) + " | Resale: " + (ticket.getAvailableForResale() ? "Listed" : "Not Listed");
		
		ticketModel.addElement(ticketDetails);
		} 
		
		JList<String> ticketList = new JList<>(ticketModel);
		ticketList.setFont(new Font("Arial", Font.PLAIN, 13));
		ticketList.setFixedCellHeight(55);
		
		JScrollPane scrollPane = new JScrollPane(ticketList);
		
		JButton closeButton = new JButton("Close");
		closeButton.setFont(new Font("Arial", Font.PLAIN, 13));
		closeButton.setForeground(BLUE);
		
		closeButton.addActionListener(e -> dispose());
		
		mainPanel.add(description, BorderLayout.NORTH);
		mainPanel.add(scrollPane, BorderLayout.CENTER);
		mainPanel.add(closeButton, BorderLayout.SOUTH);

		add(mainPanel, BorderLayout.CENTER);
		
		if (userTickets.isEmpty()) {
			JOptionPane.showMessageDialog(this, "You have not purchased any tickets yet", "No tickets Found", JOptionPane.INFORMATION_MESSAGE);
		}

}

}
