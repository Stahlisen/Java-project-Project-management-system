package project_frest460_danko234;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

public class addmember {

	
	public void newMember(projectmember newMember) throws ClassNotFoundException {
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
				 	
				 	int strSQL = stmt1.executeUpdate (" INSERT INTO projectmembers  (pnr, name, username, password, projectid, role) VALUES ('" + newMember.getPnr() + "','" + newMember.getName()
				 		+ "','"	+ newMember.getLogin() + "','" + newMember.getPw() + "','" + newMember.getProjectid() + "','" + newMember.getRole()
				 		 + "')");
				 	
				 	
					
				 	
				 	stmt1.close();
				 	conn.close();
				 	
				 	String s = "y";
				 	
				 	newmember success = new newmember();
				 	
				 	success.registercompleted(s);
				 	
				 						
	}catch (SQLException e)
	{
		String s = "n";
		newmember success = new newmember();
		success.registercompleted(s);
		System.out.println("ERROR: " + e.getMessage() );
	
				 	
	}
	}

}
	

