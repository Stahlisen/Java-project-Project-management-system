
import java.beans.Statement;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fredrik
 */
public class databaseconnection {
    
    public String[] getProjectinfo(String customerid, String projectid) throws ClassNotFoundException, SQLException{
    
                                    String [] projectinfo = new String [6];
    try{
				Class.forName("com.mysql.jdbc.Driver"); 
				String dbmsURL = "mysql.iei.liu.se"; 
				String db = "dod1311_project"; 
				String user = "dod1311"; 
				String pwd = "dod131113"; 
				
				String strConn = "jdbc:mysql://" + dbmsURL + "/" + db 
						 	+ "?user=" + user + "&password=" + pwd; 
						 	Connection conn = (Connection) DriverManager.getConnection(strConn);
						 	
						 	java.sql.Statement stmt = conn.createStatement();
                                                        java.sql.Statement stmt1 = conn.createStatement();
                                                       
						 	String sql = "SELECT * FROM projects WHERE projectid='" + projectid + "';";
                                                        String sql1 = "SELECT time FROM projectsummary WHERE projectid='" + projectid + "';";
                                                        ResultSet rs = stmt.executeQuery(sql);
                                                        ResultSet rs1 = stmt1.executeQuery(sql1);
                                                        rs.next();
                                                        rs1.next();
						 	
						 	
                                                       projectinfo [0] = rs.getString("projectid");
                                                       projectinfo [1] = rs.getString("projectmanager");
                                                       projectinfo [2] = rs.getString("description");
                                                       projectinfo [3] = rs.getString("status");
                                                       projectinfo [4] = rs.getString("time");
                                                       projectinfo [5] = rs1.getString("time");
                                                       
                                                       
                                                       
                                                       stmt.close();
                                                       stmt1.close();
                                                       rs.close();
                                                       rs1.close();
                                                       
                                                       
                                                       
                                                       
                                                     
                                                       
                                                            
                                                            
                                                            
                                                           
                                                                        
                                                            
                                                            
                                                            
                                                        }
    catch (SQLException e)
{
System.out.println("ERROR1: " + e.getMessage() );
}
        return projectinfo;
						 	
}
    
    public String getprojectCost (String projectid) throws ClassNotFoundException {
        String projectcost = null;
        
        try{
				Class.forName("com.mysql.jdbc.Driver"); 
				String dbmsURL = "mysql.iei.liu.se"; 
				String db = "dod1311_project"; 
				String user = "dod1311"; 
				String pwd = "dod131113"; 
				
				String strConn = "jdbc:mysql://" + dbmsURL + "/" + db 
						 	+ "?user=" + user + "&password=" + pwd; 
						 	Connection conn = (Connection) DriverManager.getConnection(strConn);
						 	
						 	java.sql.Statement stmt = conn.createStatement();
                                                        
                                                       
						 	String sql = "SELECT * FROM projects WHERE projectid='" + projectid + "';";
                                                        
                                                        ResultSet rs = stmt.executeQuery(sql);
                                                       
                                                        rs.next();
                                                        
                                                        projectcost = rs.getString("budget");
                                                        
                                                        
        }                                             
    catch (SQLException e)
{
System.out.println("ERROR1: " + e.getMessage() );
}    
						 	
        
        
        
        return projectcost;
        
        
        
    }
    }

