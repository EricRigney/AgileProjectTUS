package tus.ie;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginSystem extends JFrame {

	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton loginButton;
	private JLabel messageLabel;
	private LoginAuthenticator authenticator;
	private LoginAttempts loginAttempts;

	private final Color NAVY = new Color(18, 32, 58);
	private final Color BLUE = new Color(45, 105, 230);
	private final Color LIGHT = new Color(245, 247, 252);
	private final Color GREY = new Color(105, 116, 135);
	private final Color RED = new Color(200, 45, 55);
	private final Color GREEN = new Color(20, 145, 85);

	public LoginSystem() {

		authenticator = new LoginAuthenticator();
		loginAttempts = new LoginAttempts();

		setTitle("EventPass - Login");
		setSize(460, 520);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		// Main Background
		JPanel mainPanel = new JPanel();
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

		// White Login Card
		JPanel card = new JPanel();
		card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
		card.setBackground(Color.WHITE);
		card.setBorder(new EmptyBorder(25, 30, 25, 30));

		JLabel heading = new JLabel("Welcome Back");
		heading.setFont(new Font("SansSerif", Font.BOLD, 24));
		heading.setForeground(NAVY);
		heading.setAlignmentX(Component.LEFT_ALIGNMENT);

		JLabel description = new JLabel("Sign in to access your account.");
		description.setFont(new Font("SansSerif", Font.PLAIN, 13));
		description.setForeground(GREY);
		description.setAlignmentX(Component.LEFT_ALIGNMENT);

		JLabel usernameLabel = new JLabel("Username");
		styleLabel(usernameLabel);

		usernameField = new JTextField();
		styleField(usernameField);

		JLabel passwordLabel = new JLabel("Password");
		styleLabel(passwordLabel);

		passwordField = new JPasswordField();
		styleField(passwordField);

		loginButton = new JButton("Sign In");
		loginButton.setFont(new Font("SansSerif", Font.BOLD, 15));
		loginButton.setForeground(Color.WHITE);
		loginButton.setBackground(BLUE);
		loginButton.setFocusPainted(false);
		loginButton.setBorderPainted(false);
		loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

		loginButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		loginButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 43));

		loginButton.setPreferredSize(new Dimension(300, 43));
		
		// Forgot Password Button
		JButton forgotButton = new JButton("Forgot Button");
		forgotButton.setFont(new Font("SanaSerif", Font.PLAIN,12));
		forgotButton.setForeground(BLUE);
		forgotButton.setBorderPainted(false);
		forgotButton.setContentAreaFilled(false);
		forgotButton.setFocusPainted(false);
		forgotButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		forgotButton.setAlignmentX(Component.RIGHT_ALIGNMENT);

		messageLabel = new JLabel(" ");
		messageLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		messageLabel.setForeground(new Color(200, 45, 55));
		messageLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

		// Footer
		JLabel footer = new JLabel("Event Pass | Ticket Booking");
		footer.setFont(new Font("SansSerif", Font.PLAIN, 10));
		footer.setForeground(GREY);
		footer.setAlignmentX(Component.CENTER_ALIGNMENT);

		card.add(heading);
		card.add(Box.createHorizontalStrut(5));
		card.add(description);
		card.add(Box.createHorizontalStrut(22));

		card.add(usernameLabel);
		card.add(Box.createHorizontalStrut(6));
		card.add(usernameField);
		card.add(Box.createHorizontalStrut(16));

		card.add(passwordLabel);
		card.add(Box.createHorizontalStrut(6));
		card.add(passwordField);
		card.add(Box.createHorizontalStrut(18));
		
		card.add(forgotButton);
		card.add(Box.createHorizontalStrut(12));

		card.add(loginButton);
		card.add(Box.createHorizontalStrut(10));
		card.add(messageLabel);
		card.add(Box.createHorizontalStrut(12));
		card.add(footer);

		// Add padding around the card
		JPanel cardContainer = new JPanel(new BorderLayout());
		cardContainer.setBackground(LIGHT);
		cardContainer.setBorder(new EmptyBorder(0, 30, 30, 30));

		cardContainer.add(card, BorderLayout.CENTER);

		mainPanel.add(header, BorderLayout.NORTH);
		mainPanel.add(cardContainer, BorderLayout.CENTER);

		add(mainPanel);

		// Button Actions
		loginButton.addActionListener(e -> login());
		passwordField.addActionListener(e -> login());
		forgotButton.addActionListener(e -> login());

	}

	private void styleLabel(JLabel label) {
		label.setFont(new Font("SansSerif", Font.BOLD, 13));
		label.setForeground(NAVY);
		label.setAlignmentX(Component.LEFT_ALIGNMENT);
	}

	private void styleField(JTextField field) {
		field.setFont(new Font("SansSerif", Font.PLAIN, 14));
		field.setPreferredSize(new Dimension(300, 40));
		field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
		field.setAlignmentX(Component.LEFT_ALIGNMENT);

		field.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(210, 218, 230)),
				new EmptyBorder(8, 10, 8, 10)));
	}

	private void login() {
		if(loginAttempts.isLockedOut()) {
			return;
		}
	
		String username = usernameField.getText().trim();
		String password = new String(passwordField.getPassword());
		
		// Check for empty Fields
		if(username.isEmpty() || password.isEmpty()) {
			messageLabel.setForeground(RED);
			
			messageLabel.setText("Please enter your username and password");
			return;
		}
		
		// Validate Login details
		if (authenticator.authenticate(username,  password)) {
			messageLabel.setForeground(GREEN);
			messageLabel.setText("Login Successful!");
			
			JOptionPane.showMessageDialog(this, "Welcome " + username + "!\nYour login was successful.", "Login Successful", JOptionPane.INFORMATION_MESSAGE);
			
			// This are will be for the booking screen which will be added later in the project
			
		}else {
			loginAttempts.recordFailedAttempt();
			passwordField.setText("");
			
			if(loginAttempts.isLockedOut()) {
				messageLabel.setForeground(RED);
				messageLabel.setText("Account locked. No attempts remianing");
				
				loginButton.setEnabled(false);
				usernameField.setEnabled(false);
				passwordField.setEnabled(false);
				
				JOptionPane.showMessageDialog(this,"You have entered incorrect details" + "three times.\nAcess Denied", " Account Locked", JOptionPane.ERROR_MESSAGE);
			} else { 
				messageLabel.setForeground(RED);
				messageLabel.setText("Incorrect details. Attempts remaining:" + loginAttempts.getAttemptsRemaining());
			}
		}
	}
				
				
	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			LoginSystem window = new LoginSystem();
			window.setVisible(true);
		});
	}
}