package tus.ie;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CreateAccountGUI extends JFrame {

	private JTextField nameField;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JPasswordField confrimPasswordField;

	private LoginAuthenticator authenticator;

	private final Color NAVY = new Color(18, 32, 58);
	private final Color BLUE = new Color(45, 105, 230);
	private final Color GREY = new Color(105, 116, 135);
	private final Color RED = new Color(200, 45, 55);

	public CreateAccountGUI(LoginAuthenticator authenticator) {

		this.authenticator = authenticator;

		setTitle("Eventpass - Create Account");
		setSize(460, 620);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBackground(NAVY);

		// Header
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
		header.setBackground(NAVY);
		header.setBorder(new EmptyBorder(25, 20, 25, 20));

		JLabel logo = new JLabel("EVENTPASS");
		logo.setFont(new Font("SansSerif", Font.BOLD, 28));
		logo.setForeground(Color.WHITE);
		logo.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel subtitle = new JLabel("Your Next Event Starts Here");
		subtitle.setFont(new Font("SansSerif", Font.PLAIN, 11));
		subtitle.setForeground(new Color(195, 207, 225));
		subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

		header.add(logo);
		header.add(Box.createVerticalStrut(8));
		header.add(subtitle);
		
		// Registration card 
		JPanel card = new JPanel();
		card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
		card.setBackground(Color.WHITE);
		card.setBorder(new EmptyBorder(25, 30, 25, 30));

		JLabel heading = new JLabel("Join EventPass");
		heading.setFont(new Font("SansSerif", Font.BOLD, 23));
		heading.setForeground(NAVY);
		heading.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		card.add(heading);
		card.add(Box.createVerticalStrut(20));

	}
}
