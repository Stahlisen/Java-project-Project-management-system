package project_frest460_danko234;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class memberview {

	private JFrame frame;
	private JLabel welcomeLabel;

	/**
	 * Launch the application.
	 */
	
	
			public void run() {
				try {
					memberview window = new memberview();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
	

	/**
	 * Create the application.
	 */
	public memberview() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBackground(SystemColor.activeCaption);
		frame.getContentPane().setForeground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 675, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel welcomeLabel = new JLabel("Logged in as: Developer/Programmer");
		welcomeLabel.setFont(new Font("Calibri", Font.BOLD, 14));
		welcomeLabel.setBounds(193, 11, 258, 20);
		frame.getContentPane().add(welcomeLabel);
		
		JButton accounthoursButton = new JButton("Account hours");
		accounthoursButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				timeaccounting newaccount = new timeaccounting();
				newaccount.run();
			}
		});
		accounthoursButton.setBounds(46, 99, 137, 23);
		frame.getContentPane().add(accounthoursButton);
		
		
	}
}
