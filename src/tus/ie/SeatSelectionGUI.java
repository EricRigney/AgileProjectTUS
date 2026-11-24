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

public class SeatSelectionGUI extends JFrame{
	
	private SeatAvailability seatAvailability;
	
	private JComboBox<String> standComboBox;
	private JComboBox<String> rowComboBox;

	private JPanel seatPanel;
	private JLabel selectLabel;
	
	private ArrayList<String> selectedSeats;
	
	private String eventName;
	private String eventDate;
	
	private final Color NAVY = new Color(18, 32, 58);
	private final Color GREEN = new Color(76, 175, 80);
	private final Color BLUE = new Color(45, 105, 230);
	private final Color GREY = new Color(180, 180, 180);
	private final Color LIGHT = new Color(245, 247, 252);
	
	public SeatSelectionGUI(String eventName, String eventDate, SeatAvailability seatAvailbility) {
		
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.seatAvailability = seatAvailability;
		
		selectedSeats = new ArrayList<>();
		
		setTitle("EventPass - Seat Selection");
		setSize(850,650);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setLayout(new BorderLayout());
		
	}
}
