package project_frest460_danko234;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;

public class timeaccounting {

	private JFrame frame;
	private JTextField reghourField;
	private JTextField OvertimehourField;
	private JTextField projectidField;
	private int selectedrole;
	private JTextField memberamountField;

	/**
	 * Launch the application.
	 */
	
			public void run() {
				try {
					timeaccounting window = new timeaccounting();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
	
	/**
	 * Create the application.
	 */
	public timeaccounting() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register time on project");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 13));
		lblNewLabel.setBounds(145, 11, 144, 14);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		String [] rolearray = {"Programmer", "Systemdeveloper", "Projectmanager"};
		
		JComboBox roleBox = new JComboBox(rolearray);
		roleBox.setBounds(53, 59, 108, 20);
		frame.getContentPane().add(roleBox);
		roleBox.setSelectedIndex(0);
		roleBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
		        selectedrole = cb.getSelectedIndex();
		        
		        if (selectedrole == 2) {
		        	
		        	memberamountField.setEnabled(true);
		        	OvertimehourField.setEnabled(false);
		        	
		        } else if (selectedrole == 0 || selectedrole == 1) {
		        	
		        	
		        	OvertimehourField.setEnabled(true);
		        	memberamountField.setEnabled(false);
		        }
		        
		        
			}
		});
		
		reghourField = new JTextField();
		reghourField.setBounds(53, 133, 86, 20);
		frame.getContentPane().add(reghourField);
		reghourField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Choose your role:");
		lblNewLabel_1.setBounds(53, 34, 92, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblRegularHours = new JLabel("Regular hours:");
		lblRegularHours.setBounds(53, 108, 86, 14);
		frame.getContentPane().add(lblRegularHours);
		
		JLabel lblOvertimeHours = new JLabel("Overtime hours (Programmer/Systemdeveloper):");
		lblOvertimeHours.setBounds(184, 108, 240, 14);
		frame.getContentPane().add(lblOvertimeHours);
		
		OvertimehourField = new JTextField();
		OvertimehourField.setColumns(10);
		OvertimehourField.setBounds(184, 133, 86, 20);
		frame.getContentPane().add(OvertimehourField);
		OvertimehourField.setEnabled(true);
		
		projectidField = new JTextField();
		projectidField.setBounds(184, 59, 86, 20);
		frame.getContentPane().add(projectidField);
		projectidField.setColumns(10);
		
		JLabel lblEnterProjectid = new JLabel("Enter project-ID:");
		lblEnterProjectid.setBounds(184, 36, 92, 14);
		frame.getContentPane().add(lblEnterProjectid);
		
		JLabel lblForManagersEnter = new JLabel("Enter amount of projectmembers in project:");
		lblForManagersEnter.setBounds(53, 184, 324, 14);
		frame.getContentPane().add(lblForManagersEnter);
		
		memberamountField = new JTextField();
		memberamountField.setColumns(10);
		memberamountField.setBounds(53, 211, 86, 20);
		frame.getContentPane().add(memberamountField);
		memberamountField.setEnabled(false);
		
		JLabel lblNewLabel_2 = new JLabel("FOR MANAGERS ONLY:");
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 13));
		lblNewLabel_2.setBounds(53, 164, 134, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(selectedrole);
				String regularhours = reghourField.getText();
				String overtimehours = OvertimehourField.getText();
				String members = memberamountField.getText();
				
				
				int reghours = Integer.parseInt(regularhours);
				System.out.println(regularhours);
				
				String projectid = projectidField.getText();
				int role = selectedrole;
				
				calculatecost newCost = new calculatecost();
				
				
				
				
				double salary = newCost.countcost(reghours, overtimehours, projectid, role, members);
				
				
				int totalhours = newCost.countHours(reghours,overtimehours, role);
				databaseinfo newsummary = new databaseinfo();
				try {
					newsummary.insertSummary(totalhours, salary, projectid);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				System.out.println(salary);
				System.out.println(totalhours);
				
				
			}
		});
		registerButton.setBounds(304, 210, 89, 23);
		frame.getContentPane().add(registerButton);
	}
}
