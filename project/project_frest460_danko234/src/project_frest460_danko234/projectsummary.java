package project_frest460_danko234;


import java.awt.Dimension;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;


import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class projectsummary extends JPanel {

	private JFrame frame;
	private JTextField costbudgetField;
	private JTextField timebudgetField;
	private JTextField enddateField;
	private JTextField currentcostField;
	private JTextField currenttimeField;
	private String selectedid;
	

	/**
	 * Launch the application.
	 */
	
			public void run() {
				try {
					projectsummary window = new projectsummary();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
	

	/**
	 * Create the application.
	 */
	public projectsummary() {
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
		
		JLabel lblProjectSummary = new JLabel("Project Summary");
		lblProjectSummary.setFont(new Font("Calibri", Font.BOLD, 14));
		lblProjectSummary.setBounds(158, 11, 112, 14);
		frame.getContentPane().add(lblProjectSummary);
		
		databaseinfo newprojectinfo = new databaseinfo();
		ArrayList<String> projectarray = new ArrayList<String>();
		projectarray = newprojectinfo.getprojects();
		
		JComboBox selectprojectidBox = new JComboBox(projectarray.toArray());
		selectprojectidBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JComboBox cb = (JComboBox)e.getSource();
		        selectedid = (String)cb.getSelectedItem();
		        databaseinfo newsummary = new databaseinfo();
		       
		        
					String[] summary;
					String[] projectinfo;
					try {
						summary = newsummary.getcurrentProject(selectedid);
						String cost = summary[0];
						String time = summary [1];
						
						currentcostField.setText(cost);
						currenttimeField.setText(time);
						projectinfo = newsummary.getProjectinfo(selectedid);
						
						String costbudget = projectinfo [0];
						String timebudget = projectinfo [1];
						String enddatebudget = projectinfo [2];
						
						costbudgetField.setText(costbudget);
						timebudgetField.setText(timebudget);
						enddateField.setText(enddatebudget);
						
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
				
		        
		        
			}
		});
		selectprojectidBox.setBounds(32, 50, 83, 20);
		frame.getContentPane().add(selectprojectidBox);
		
		JLabel lblNewLabel = new JLabel("Select project-ID:");
		lblNewLabel.setBounds(32, 32, 94, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblProjectInformation = new JLabel("Project information:");
		lblProjectInformation.setBounds(99, 90, 104, 14);
		frame.getContentPane().add(lblProjectInformation);
		
		costbudgetField = new JTextField();
		costbudgetField.setBounds(99, 116, 86, 20);
		frame.getContentPane().add(costbudgetField);
		costbudgetField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Cost-budget:");
		lblNewLabel_1.setBounds(20, 119, 69, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		timebudgetField = new JTextField();
		timebudgetField.setBounds(99, 147, 86, 20);
		frame.getContentPane().add(timebudgetField);
		timebudgetField.setColumns(10);
		
		JLabel lblTimebudget = new JLabel("Time (hours):");
		lblTimebudget.setBounds(20, 150, 69, 14);
		frame.getContentPane().add(lblTimebudget);
		
		enddateField = new JTextField();
		enddateField.setBounds(99, 178, 86, 20);
		frame.getContentPane().add(enddateField);
		enddateField.setColumns(10);
		
		JLabel lblEnddate = new JLabel("End-date:");
		lblEnddate.setBounds(20, 181, 69, 14);
		frame.getContentPane().add(lblEnddate);
		
		JLabel lblProjectSummary_1 = new JLabel("Project summary:");
		lblProjectSummary_1.setBounds(242, 90, 104, 14);
		frame.getContentPane().add(lblProjectSummary_1);
		
		currentcostField = new JTextField();
		currentcostField.setColumns(10);
		currentcostField.setBounds(331, 116, 86, 20);
		frame.getContentPane().add(currentcostField);
		
		JLabel lblCurrentCost = new JLabel("Current cost:");
		lblCurrentCost.setBounds(252, 119, 69, 14);
		frame.getContentPane().add(lblCurrentCost);
		
		JLabel lblCurrentTimehours = new JLabel("Current time(hours):");
		lblCurrentTimehours.setBounds(217, 150, 104, 14);
		frame.getContentPane().add(lblCurrentTimehours);
		
		currenttimeField = new JTextField();
		currenttimeField.setColumns(10);
		currenttimeField.setBounds(331, 147, 86, 20);
		frame.getContentPane().add(currenttimeField);
	
		
	}
	
	public void showMessage() {
		
		JOptionPane.showMessageDialog(frame,
			    "The project has no summary registered",
			    "Message",
			    JOptionPane.INFORMATION_MESSAGE);
		
		
		
	}
public void showMessage1() {
		
		JOptionPane.showMessageDialog(frame,
			    "The project has no information registerd",
			    "Message",
			    JOptionPane.INFORMATION_MESSAGE);
}
}