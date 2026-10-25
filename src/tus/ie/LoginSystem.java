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
	private LoginAttempts loginAttempts
	
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