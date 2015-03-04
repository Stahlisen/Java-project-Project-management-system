package project_frest460_danko234;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class databaseinfo {
	
	
	public ArrayList<String> getprojectLeaders() {
		ArrayList<String> projectleaders = new ArrayList<String>();
		try{
			Class.forName("com.mysql.jdbc.Driver"); 
			String dbmsURL = "mysql.iei.liu.se"; 
			String db = "dod1311_project"; 
			String user = "dod1311"; 
			String pwd = "dod131113"; 
			String strConn = "jdbc:mysql://" + dbmsURL + "/" + db 
					 	+ "?user=" + user + "&password=" + pwd; 
					 	Connection conn = (Connection) DriverManager.getConnection(strConn);			 	
					 	Statement stmt1 = (Statement) conn.createStatement();
					 	ResultSet rs = stmt1.executeQuery ("SELECT name FROM projectmembers WHERE role='Projectmanager';"); 
					 	rs.beforeFirst();
					 	while (rs.next()) {
					 		projectleaders.add(rs.getString("name"));
					 		}
		} catch (Exception e)
		{
			System.out.println("ERROR: " + e.getMessage() );
		}
		return projectleaders;
	}
	
	public ArrayList<String> getprojects() {
		ArrayList<String> arrayofprojects = new ArrayList<String>();
		try{
			Class.forName("com.mysql.jdbc.Driver"); 
			String dbmsURL = "mysql.iei.liu.se"; 
			String db = "dod1311_project"; 
			String user = "dod1311"; 
			String pwd = "dod131113"; 
			String strConn = "jdbc:mysql://" + dbmsURL + "/" + db 
					 	+ "?user=" + user + "&password=" + pwd; 
					 	Connection conn = (Connection) DriverManager.getConnection(strConn);			 	
					 	Statement stmt1 = (Statement) conn.createStatement();
					 	ResultSet rs = stmt1.executeQuery ("SELECT projectid FROM projects"); 
					 	rs.beforeFirst();
					 	while (rs.next()) {
					 		arrayofprojects.add(rs.getString("projectid"));
					 		}
		} catch (Exception e)
		{
			System.out.println("ERROR: " + e.getMessage() );
		}
		return arrayofprojects;
	}
	
	public void insertProject (project newProject) throws ClassNotFoundException {
		
		try{
			Class.forName("com.mysql.jdbc.Driver"); 
			String dbmsURL = "mysql.iei.liu.se"; 
			String db = "dod1311_project"; 
			String user = "dod1311"; 
			String pwd = "dod131113"; 
			
			String strConn = "jdbc:mysql://" + dbmsURL + "/" + db 
					 	+ "?user=" + user + "&password=" + pwd; 
					 	Connection conn = (Connection) DriverManager.getConnection(strConn);
					 	
					 	Statement stmt1 = (Statement) conn.createStatement();
					 	
					 	int strSQL = stmt1.executeUpdate (" INSERT INTO projects  (projectid, startdate, description, budget, time, customerid, enddate, projectmanager, status) VALUES ('" + newProject.getProjectid() + "','" + 
					 	newProject.getStartdate() + "','" + newProject.getDescription() + "','" + newProject.getCost() + "','" + newProject.getTime() + "','" + newProject.getCustomerid() + "','" + 
					 	newProject.getEnddate() + "','" + newProject.getManager() + "','" +  newProject.getStatus() +  "')");
					 	
					 	
					 	stmt1.close();
					 	conn.close();
					 	
					 	String s = "y";
					 	
					 	addproject success = new addproject();
					 	
					 	success.registercompleted(s);
					 	
					 						
		}catch (SQLException e)
		{
			String s = "n";
			addproject success = new addproject();
			success.registercompleted(s);
			System.out.println("ERROR: " + e.getMessage() );
		
					 	
		}
		}
	
		public void insertSummary(int totalhours, double salary, String projectid) throws ClassNotFoundException {
			
			try{
				Class.forName("com.mysql.jdbc.Driver"); 
				String dbmsURL = "mysql.iei.liu.se"; 
				String db = "dod1311_project"; 
				String user = "dod1311"; 
				String pwd = "dod131113"; 
				
				String strConn = "jdbc:mysql://" + dbmsURL + "/" + db 
						 	+ "?user=" + user + "&password=" + pwd; 
						 	Connection conn = (Connection) DriverManager.getConnection(strConn);
						 	
						 	
						 	Statement stmt1 = (Statement) conn.createStatement();
						 	Statement stmt2 = (Statement) conn.createStatement();
						 	
						 	
						 	
						 	
						 	
						 	ResultSet rs1 = stmt1.executeQuery ("SELECT cost FROM projectsummary WHERE projectid='" + projectid + "';");
						 	ResultSet rs2 = stmt2.executeQuery ("SELECT time FROM projectsummary WHERE projectid='" + projectid + "';");
						 	
						 	
						 	if (!rs1.next()) {
						 		
						 		int strSQL = stmt1.executeUpdate (" INSERT INTO projectsummary (projectid, cost, time)  VALUES('" + projectid +  "','" + salary + "','" + totalhours +   "');");
						 	} else {
						 	
						 	
						 	rs2.next();
						 	int currenttime = Integer.parseInt(rs2.getString(1));
						 	double currentcost = Double.parseDouble(rs1.getString(1));
						 	double cost = salary+currentcost;
						 	int time = totalhours+currenttime;
						 	
						 	
						 	
						 	
						 	int strSQL = stmt1.executeUpdate (" UPDATE projectsummary SET cost='" +  cost + "', time='" + time + "' WHERE projectid='" + projectid + "';");
						 	
						 	}
						 	stmt1.close();
						 	stmt2.close();
						 	conn.close();
						 	
						 	String s = "y";
						 	
						 	addproject success = new addproject();
						 	
						 	success.registercompleted(s);
						 	
						 						
			}catch (SQLException e)
			{
				String s = "n";
				addproject success = new addproject();
				success.registercompleted(s);
				System.out.println("ERROR: " + e.getMessage() );
			
						 	
			}
			
				
			
		}
		
		public String[] getcurrentProject(String projectid) throws ClassNotFoundException {
			String[] summary = new String [2];
			
			try{
				Class.forName("com.mysql.jdbc.Driver"); 
				String dbmsURL = "mysql.iei.liu.se"; 
				String db = "dod1311_project"; 
				String user = "dod1311"; 
				String pwd = "dod131113"; 
				
				String strConn = "jdbc:mysql://" + dbmsURL + "/" + db 
						 	+ "?user=" + user + "&password=" + pwd; 
						 	Connection conn = (Connection) DriverManager.getConnection(strConn);
						 	
						 	
						 	Statement stmt1 = (Statement) conn.createStatement();
						 	Statement stmt2 = (Statement) conn.createStatement();
						 	
						 	
						 	
						 	
						 	
						 	ResultSet rs1 = stmt1.executeQuery ("SELECT cost FROM projectsummary WHERE projectid='" + projectid + "';");
						 	ResultSet rs2 = stmt2.executeQuery ("SELECT time FROM projectsummary WHERE projectid='" + projectid + "';");
						 	
						 	if (!rs1.next()) {
						 		
						 		projectsummary nosummary = new projectsummary();
						 		nosummary.showMessage();
						 	} else {
						 		rs2.next();
						 		
						 		summary [0] = (rs1.getString("cost"));
						 		summary [1] = (rs2.getString("time"));
						 		
						 		
						 	}
						 	
						 	
			} catch (SQLException e)
			{
				
				System.out.println("ERROR: " + e.getMessage() );
			
						 	
			}
			return summary;
		}

		public String[] getProjectinfo(String selectedid) throws ClassNotFoundException {
			
			// TODO Auto-generated method stub
			String [] projectinfo = new String [3];
			try{
				Class.forName("com.mysql.jdbc.Driver"); 
				String dbmsURL = "mysql.iei.liu.se"; 
				String db = "dod1311_project"; 
				String user = "dod1311"; 
				String pwd = "dod131113"; 
				
				String strConn = "jdbc:mysql://" + dbmsURL + "/" + db 
						 	+ "?user=" + user + "&password=" + pwd; 
						 	Connection conn = (Connection) DriverManager.getConnection(strConn);
						 	
						 	
						 	Statement stmt1 = (Statement) conn.createStatement();
						 	Statement stmt2 = (Statement) conn.createStatement();
						 	Statement stmt3 = (Statement) conn.createStatement();

						 	
						 	
						 	
						 	
						 	ResultSet rs1 = stmt1.executeQuery ("SELECT budget FROM projects WHERE projectid='" + selectedid + "';");
						 	ResultSet rs2 = stmt2.executeQuery ("SELECT time FROM projects WHERE projectid='" + selectedid + "';");
						 	ResultSet rs3 = stmt3.executeQuery ("SELECT enddate FROM projects WHERE projectid='" + selectedid + "';");
						 	
						 	if(!rs1.next()){
						 		
						 		projectsummary message = new projectsummary();
						 		message.showMessage1();
						 		
						 	}
			
						 	else {
						 		rs2.next();
						 		rs3.next();
						 		projectinfo [0] = rs1.getString("budget");
						 		projectinfo [1] = rs2.getString("time");
						 		projectinfo [2] = rs3.getString("enddate");
						 		}
		}catch (SQLException e)
		{
			
			System.out.println("ERROR: " + e.getMessage() );
		
					 	
		}return projectinfo;
		
		
	}
}
	


