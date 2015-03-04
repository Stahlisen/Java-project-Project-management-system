package project_frest460_danko234;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class checkLogin {

	
	public checkLogin() {
		
		
	}
	
	public void db_checkLogin(String username, String password) throws ClassNotFoundException {
		
	
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
					 	
					 	//Kontrollerar ifall username och password finns i databasen
					 	
					 	ResultSet rs = stmt1.executeQuery (" SELECT * FROM projectmembers WHERE username='" + username + "' AND password='" + password + "';");
					 	
					 	String projectmanager;
					 	//Ser ifall 
					 	if (rs.isBeforeFirst() == true) {
					 		
					 		rs.first();
					 		System.out.println(rs.getString("role"));
					 		
					 		
					 		
					 		
					 		
					 		if (rs.getString("role").equals("Projectmanager")) {
					 			projectmanager = "yes";
					 			
					 			login rolecheck = new login();
					 			
					 			rolecheck.roleCheck(projectmanager);
					 			
					 			
					 			
					 			
					 		} else if (rs.getString("role").equals("Systemdeveloper") || rs.getString("role").equals("Programmer")) {
					 			
					 			login rolecheck = new login();
					 			projectmanager = "no";
					 			
					 			
					 			rolecheck.roleCheck(projectmanager);
					 			
					 		}
					 		
					 		
					 	} else {
					 		
					 		String incorrect;
					 		login loginCheck = new login();
					 		incorrect = "no";
					 		loginCheck.logincheck(incorrect);
					 	}
					 	
					 	
					 	
					 	
					 	
					 	stmt1.close();
					 	conn.close();
					 	
					 	
					 
						
						
		}catch (SQLException e)
		{
			System.out.println("ERROR: " + e.getMessage() );
		}
		
		
	}
	
}
