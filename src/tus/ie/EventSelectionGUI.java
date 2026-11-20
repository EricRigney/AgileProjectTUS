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
	
	private final Color NAVY = new Color(18,32,58);
	private final Color BLUE = new Color(45,105,230);
	private final Color LIGHT = new Color(245,247,252);
	private final Color GREY = new Color(105,116,135);
	
	
	public EventSelectionGUI() {
		
		setTitle("EventPass -Find Tickets");
		setSize(600,450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		// Event Panel
		JPanel eventPanel = new JPanel(new BorderLayout());
		eventPanel.setBackground(LIGHT);
		
		
	}
}
