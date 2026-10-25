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
	
	private final Color NAVY = new Color(18,32,58);
	private final Color BLUE = new Color(45,105,230);
	private final Color LIGHT = new Color(245,247,252);
	private final Color GREY = new Color(105,116,135);

	public LoginSystem() {
		
		authenticator = new LoginAuthenticator();
		loginAttempts = new LoginAttempts();
		
		setTitle("EventPass - Login");
		setSize(460,520);
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
		header.setBorder(new EmptyBorder(25,20,25,20));
		
		JLabel logo = new JLabel("EVENTPASS");
		logo.setFont(new Font("SansSerif", Font.BOLD, 28));
		logo.setForeground(Color.WHITE);
		logo.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel subtitle = new JLabel("Your Next Event Starts Here");
		subtitle.setFont(new Font("SanSerif",Font.PLAIN,11));
		subtitle.setForeground(new Color(195,207,225));
		subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		header.add(logo);
		header.add(Box.createVerticalStrut(8));
		
		//White Login Card
		JPanel card = new JPanel();
		card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
		card.setBackground(Color.WHITE);
		card.setBorder(new EmptyBorder(25,30,25,30));
		
		JLabel heading = new JLabel("Welcome Back");
		heading.setFont(new Font("SansSerif", Font.BOLD, 24));
		heading.setForeground(NAVY);
		heading.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JLabel description = new JLabel("Sign in to access your account.");
		description .setFont(new Font("SansSerif", Font.PLAIN, 13));
		description .setForeground(GREY);
		description .setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JLabel usernameLabel = new JLabel("Username");
		styleLabel(usernameLabel);
		
		usernameField = new JTextField();
		styleLabel(usernameField);
		
		JLabel passwordLabel = new JLabel("Password");
		styleLabel(passwordLabel);
		
		passwordField = new JPasswordField();
		styleLabel(passwordField);
		
		
		
	}

		
	JFrame enter = new JFrame("Login System");
	enter.setSize(400,350);
	enter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	enter.setLocationRelativeTo(null);
	
	JPanel board = new JPanel();
	board.setLayout(new GridLayout(7,2,6,6));
	board.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
	
	JLabel usernameLabel = new JLabel ("Username:");
	JTextField usernameField = new JTextField();
	
	JLabel passwordLabel = new JLabel ("Password:");
	JTextField passwordField = new JTextField();
	
	JButton loginButton = new JButton ("Login:");
	
	board.add(usernameLabel);
	board.add(usernameField);
	
	board.add(passwordLabel);
	board.add(passwordField);
	
	board.add(new JLabel(""));
	board.add(loginButton);
	
	enter.add(board);
	enter.setVisible(true);
	
	loginButton.addActionListener(e -> {
		String username = usernameField.getText();
		String password = passwordField.getText();
		
		if (username.isEmpty() || password.isEmpty()) {
			JOptionPane.showMessageDialog(enter, "Please enter your username and password");
			
		} else {
			JOptionPane.showMessageDialog(enter, "Login button pressed");

		}

	});
	
	}
	
	public static void main(String[] args) {

}