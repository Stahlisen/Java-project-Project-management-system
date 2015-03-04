package project_frest460_danko234;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.SystemColor;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;

public class newmember {

	private JFrame frame;
	private JTextField idnumberField;
	private JTextField nameField;
	private JTextField usernameField;
	private JTextField passwordField;
	private JTextField roleField;
	private JLabel lblAddNewProject;
	private JButton addButton;
	private String selectedid;

	/**
	 * Launch the application.
	 */
	
			public void run() {
				try {
					newmember window = new newmember();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
	

	/**
	 * Create the application.
	 */
	public newmember() {
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
		
		idnumberField = new JTextField();
		idnumberField.setBounds(58, 44, 86, 20);
		frame.getContentPane().add(idnumberField);
		idnumberField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setBounds(58, 88, 86, 20);
		frame.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		usernameField = new JTextField();
		usernameField.setBounds(58, 130, 86, 20);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setBounds(58, 173, 86, 20);
		frame.getContentPane().add(passwordField);
		passwordField.setColumns(10);
		
		roleField = new JTextField();
		roleField.setBounds(275, 88, 86, 20);
		frame.getContentPane().add(roleField);
		roleField.setColumns(10);
		
		JLabel lblIdnumber = new JLabel("ID-number");
		lblIdnumber.setBounds(58, 30, 86, 14);
		frame.getContentPane().add(lblIdnumber);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(58, 75, 86, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(58, 116, 86, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblProjectid = new JLabel("Project");
		lblProjectid.setBounds(275, 30, 86, 14);
		frame.getContentPane().add(lblProjectid);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(58, 161, 86, 14);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setBounds(275, 75, 86, 14);
		frame.getContentPane().add(lblRole);
		
		lblAddNewProject = new JLabel("Add new project member");
		lblAddNewProject.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAddNewProject.setBounds(121, 11, 182, 14);
		frame.getContentPane().add(lblAddNewProject);
		
		addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String idnumber = idnumberField.getText();
				String name = nameField.getText();
				String username = usernameField.getText();
				String password = passwordField.getText();
				String projectid = selectedid;
				String role = roleField.getText();
				
				projectmember newMember = new projectmember(idnumber, name, username, password, role, projectid);
				addmember a = new addmember();
				try {
					a.newMember(newMember);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		addButton.setBounds(275, 172, 112, 23);
		frame.getContentPane().add(addButton);
		
		JButton clearButton = new JButton("Clear fields");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				idnumberField.setText("");
				nameField.setText("");
				usernameField.setText("");
				passwordField.setText("");
				
				roleField.setText("");
				
				
			}
		});
		clearButton.setBounds(275, 129, 112, 23);
		frame.getContentPane().add(clearButton);
		
		databaseinfo newprojectinfo = new databaseinfo();
		ArrayList<String> projectarray = new ArrayList<String>();
		projectarray = newprojectinfo.getprojects();
		

		JComboBox comboBox = new JComboBox(projectarray.toArray());
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
		        selectedid = (String)cb.getSelectedItem();
		        
			}
		});
	
		comboBox.setBounds(275, 44, 86, 20);
		frame.getContentPane().add(comboBox);
	}
	
	public void registercompleted(String s) {
		if (s == "y") {
			
		
			 
			JOptionPane.showMessageDialog(frame,
				    "User has been added! ",
				    "Registration completed!",
				    JOptionPane.INFORMATION_MESSAGE);
			
			
			
			
			
			
		} else {
			
			JOptionPane.showMessageDialog(frame,
				    "Something went wrong, try again! ",
				    "ERROR",
				    JOptionPane.WARNING_MESSAGE);
		}
		
	}
}
