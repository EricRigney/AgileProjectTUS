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
	
	private final Color NAVY = new Color(18,32,58);
	private final Color BLUE = new Color(45,105,230);
	private final Color GREY = new Color(105,116,135);
	private final Color RED = new Color(200,45,55);
	
	public CreateAccountGUI(LoginAuthenticator authenticator) {
		
		this.authenticator = authenticator;
		
		setTitle("Eventpass - Create Account");
		setSize(460,620);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBackground(NAVY);
	}
}
