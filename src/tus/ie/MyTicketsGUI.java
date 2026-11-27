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

public class MyTicketsGUI  extends JFrame{
	
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
	}
	
}
