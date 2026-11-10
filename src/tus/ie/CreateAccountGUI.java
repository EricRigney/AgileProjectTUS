package tus.ie;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CreateAccountGUI extends JFrame {

	private JTextField nameField;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JPasswordField confirmPasswordField;

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

		// Name
		card.add(createLabel("Full Name"));
		nameField = createTextField();
		card.add(nameField);
		card.add(Box.createVerticalStrut(12));
		
		// Username
		card.add(createLabel("Username"));
		usernameField = createTextField();
		card.add(usernameField);
		card.add(Box.createVerticalStrut(12));
		
		// Password
		card.add(createLabel("Password"));
		passwordField = new JPasswordField();
		styleField(passwordField);
		card.add(passwordField);
		card.add(Box.createVerticalStrut(12));
		
		// Confirm Password
		card.add(createLabel("Confirm Password"));
		confirmPasswordField = new JPasswordField();
		styleField(confirmPasswordField);
		card.add(confirmPasswordField);
		card.add(Box.createVerticalStrut(22));
		
		// Create Button
		JButton createButton = new JButton("Create Button");
		createButton.setFont(new Font("SansSerif", Font.BOLD, 15));
		createButton.setForeground(Color.WHITE);
		createButton.setBackground(BLUE);
		createButton.setFocusPainted(false);
		createButton.setBorderPainted(false);
		createButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		createButton.setMaximumSize(new Dimension(Integer.MAX_VALUE,43));
		createButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		// Back Button
		JButton backButton = new JButton("Create Button");
		backButton.setForeground(BLUE);
		backButton.setBorderPainted(false);
		backButton.setFocusPainted(false);
		backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		card.add(createButton);
		card.add(Box.createVerticalStrut(10));
		card.add(backButton);
		
		JPanel container = new JPanel(new BorderLayout());
		container.setBackground(new Color(245,247,252));
		container.setBorder(new EmptyBorder(0,30,30,30));
		container.add(card, BorderLayout.CENTER);
		
		mainPanel.add(header, BorderLayout.NORTH);
		mainPanel.add(container, BorderLayout.CENTER);
		
		add(mainPanel);
		
		// Button Actions
		createButton.addActionListener(e -> createAccount());
		backButton.addActionListener(e -> dispose());

	}

	private JLabel createLabel(String text) {

		JLabel label = new JLabel(text);
		label.setFont(new Font("SansSerif", Font.BOLD, 13));
		label.setForeground(NAVY);
		label.setAlignmentX(Component.LEFT_ALIGNMENT);

		return label;

	}

	private JTextField createTextField() {

		JTextField field = new JTextField();
		styleField(field);

		return field;
	}

	private void styleField(JTextField field) {

		field.setFont(new Font("SansSerif", Font.PLAIN, 14));
		field.setPreferredSize(new Dimension(300, 40));
		field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
		field.setAlignmentX(Component.LEFT_ALIGNMENT);

		field.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(210, 218, 230)),
				new EmptyBorder(8, 10, 8, 10)));

	}
	
	// Account Registration
	private void createAccount() {
		
		String name = nameField.getText().trim();
		String username = usernameField.getText().trim();
		
		String password = new String(passwordField.getPassword());
		String confirmPassword = new String(confirmPasswordField.getPassword());
		
		// Check empty fields
		if(name.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
			
			JOptionPane.showMessageDialog(this, "Please complete all fields.", "Missing Details", JOptionPane.WARNING_MESSAGE);
			
			return;
		}
		
		// Check username length
		if (username.length() < 3) {
			
			JOptionPane.showMessageDialog(this,"Username must contain at least 3 characters.", "Invalid Username",JOptionPane.WARNING_MESSAGE);
			
			return;
		}
	}
	
}
