package project_frest460_danko234;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login {

	private JFrame frame;
	private JTextField usernameField;
	private JTextField passwordField;
	private JLabel passwordLabel;
	private JLabel loginLabel;
	private JFrame frame2;

	/**
	 * Launch the application.
	 */
	
		
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
	

	/**
	 * Create the application.
	 */
	public login() {
		
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 675, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		usernameField = new JTextField();
		usernameField.setBounds(267, 182, 86, 20);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Calibri", Font.PLAIN, 11));
		usernameLabel.setBounds(267, 167, 58, 14);
		frame.getContentPane().add(usernameLabel);
		
		passwordField = new JTextField();
		passwordField.setBounds(267, 257, 86, 20);
		frame.getContentPane().add(passwordField);
		passwordField.setColumns(10);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Calibri", Font.PLAIN, 11));
		passwordLabel.setBounds(267, 242, 46, 14);
		frame.getContentPane().add(passwordLabel);
		
		loginLabel = new JLabel("Login");
		loginLabel.setFont(new Font("Calibri", Font.BOLD, 16));
		loginLabel.setBounds(279, 115, 46, 14);
		frame.getContentPane().add(loginLabel);
		
		JButton loginButton = new JButton("Log in");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String username = usernameField.getText();
				String password = passwordField.getText();
				
				checkLogin newCheck = new checkLogin();
				try {
					newCheck.db_checkLogin(username, password);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		loginButton.setFont(new Font("Calibri", Font.PLAIN, 14));
		loginButton.setBounds(264, 315, 89, 23);
		frame.getContentPane().add(loginButton);
	}
	
	public void logincheck(String correct) {
		if (correct == "no") {
			
			System.out.println("Wrong information or does not exist");
			JOptionPane.showMessageDialog(frame,
				    "You have either entered an incorrect username or password, or your username doesn't exist",
				    "Could not login",
				    JOptionPane.WARNING_MESSAGE);
			
		}
		
	}
	public void roleCheck (String isPM) {
		
		if (isPM == "yes") {
			
			pmview newpmView = new pmview();
			
			newpmView.run();
			
			
			
			
			
			
		} else if (isPM == "no") {
			
			memberview newmemView = new memberview();
			
			newmemView.run();
			
			
		}
		
	}
}
