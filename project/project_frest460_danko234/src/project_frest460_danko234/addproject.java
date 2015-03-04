package project_frest460_danko234;

import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class addproject {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private String selectedManager;
	private String selectedStatus;

	/**
	 * Launch the application.
	 */
	
		
			public void run() {
				try {
					addproject window = new addproject();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
	

	/**
	 * Create the application.
	 */
	public addproject() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 482, 481);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("Create new project");
		titleLabel.setFont(new Font("Calibri", Font.BOLD, 14));
		titleLabel.setBounds(170, 11, 125, 14);
		frame.getContentPane().add(titleLabel);
		
		JLabel lblProjectId = new JLabel("Project id");
		lblProjectId.setBounds(38, 58, 86, 14);
		frame.getContentPane().add(lblProjectId);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(38, 83, 86, 20);
		frame.getContentPane().add(textField_1);
		
		JLabel lblStartDate = new JLabel("Start date");
		lblStartDate.setBounds(38, 114, 86, 14);
		frame.getContentPane().add(lblStartDate);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(38, 139, 86, 20);
		frame.getContentPane().add(textField_2);
		
		JLabel lblEstimatedEnddate = new JLabel("Estimated end-date");
		lblEstimatedEnddate.setBounds(38, 170, 108, 14);
		frame.getContentPane().add(lblEstimatedEnddate);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(38, 195, 86, 20);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(212, 83, 213, 76);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblProjectDescription = new JLabel("Project description");
		lblProjectDescription.setBounds(212, 58, 125, 14);
		frame.getContentPane().add(lblProjectDescription);
		
		JLabel lblProjectBudget = new JLabel("Project Cost");
		lblProjectBudget.setBounds(212, 170, 108, 14);
		frame.getContentPane().add(lblProjectBudget);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(212, 195, 86, 20);
		frame.getContentPane().add(textField_5);
		
		JLabel lblProjectTimehours = new JLabel("Project time (hours)");
		lblProjectTimehours.setBounds(212, 226, 108, 14);
		frame.getContentPane().add(lblProjectTimehours);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(212, 251, 86, 20);
		frame.getContentPane().add(textField_6);
		
		JLabel lblCustomerid = new JLabel("Customer-ID");
		lblCustomerid.setBounds(38, 226, 108, 14);
		frame.getContentPane().add(lblCustomerid);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(38, 251, 86, 20);
		frame.getContentPane().add(textField_7);
		
		JLabel lblProjectLeader = new JLabel("Projectmanager");
		lblProjectLeader.setBounds(212, 282, 108, 14);
		frame.getContentPane().add(lblProjectLeader);
		
		
		databaseinfo newleaders = new databaseinfo();
		ArrayList<String> managerarray = new ArrayList<String>();
		managerarray = newleaders.getprojectLeaders();
		

		JComboBox comboBox = new JComboBox(managerarray.toArray());
		comboBox.setBounds(212, 307, 108, 20);
		frame.getContentPane().add(comboBox);
		comboBox.setSelectedIndex(1);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent f) {
				
				JComboBox mg = (JComboBox)f.getSource();
				selectedManager = (String)mg.getSelectedItem();
			}
			
		});
		
		
		JButton createprojectButton = new JButton("Create project");
		createprojectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String customerid = textField_7.getText();
				String projectid = textField_1.getText();
				String startdate = textField_2.getText();
				String enddate = textField_3.getText();
				String status = selectedStatus;
				String description = textField_4.getText();
				String cost = textField_5.getText();
				String time = textField_6.getText();
				String manager = selectedManager;
				
				project newProject = new project(customerid, projectid, startdate, enddate, status, description, cost, time, manager);
				
				databaseinfo createnew = new databaseinfo();
				
					try {
						createnew.insertProject(newProject);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				
				
			}
		});
		createprojectButton.setBounds(336, 352, 108, 23);
		frame.getContentPane().add(createprojectButton);
		
		JLabel lblProjectstatus = new JLabel("Projectstatus");
		lblProjectstatus.setBounds(336, 226, 108, 14);
		frame.getContentPane().add(lblProjectstatus);
		ArrayList<String> statusarray = new ArrayList<String>();
		statusarray.add("Planerat");
		statusarray.add("Aktivt");
		statusarray.add("Slutfört");
		
		
		
		JComboBox statusbox = new JComboBox(statusarray.toArray());
		statusbox.setBounds(336, 251, 77, 20);
		frame.getContentPane().add(statusbox);
		statusbox.setSelectedIndex(1);
		statusbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
		        selectedStatus = (String)cb.getSelectedItem();
		        
			}
		});
		
		
		
	}
	
	public void registercompleted(String s) {
		if (s == "y") {
			
		
			 
			JOptionPane.showMessageDialog(frame,
				    "Registration completed!",
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
