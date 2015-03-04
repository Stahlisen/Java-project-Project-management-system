/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fredrik
 */
@WebServlet(name = "servlet", urlPatterns = {"/servlet"})
public class servlet extends HttpServlet {
    static String projectid;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        
        String customerid = request.getParameter("customerid");
        projectid = request.getParameter("projectid");
        databaseconnection newCon = new databaseconnection();
        
        
        out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Project information</title>");            
            out.println("</head>");
            out.println("<body><center>");
            out.println("<h1>Project summary for customer-id: " + customerid + " project-id: " + projectid + "</h1>");
            out.println("<table border ='1'>");
            String [] Datatable;
           
                                                     databaseconnection newConnection = new databaseconnection();
                                                     Datatable = newConnection.getProjectinfo(customerid, projectid);
                                                    out.println("<table border='1'>");
                                                    out.println("<tr>");
                                                    out.println("<th>" +  "project-ID "+ "</th>"); 
                                                    out.println("<th>" +  "Project Manager "+ "</th>"); 
                                                    out.println("<th>" +  "Description "+ "</th>"); 
                                                    out.println("<th>" +  "Status "+ "</th>"); 
                                                    out.println("<th>" +  "Time budget(hours "+ "</th>"); 
                                                    out.println("<th>" + "Hours spent on project" + "</th>" );
                                                    out.println("</tr>");
                                                    out.println("<tr>");
                                                    out.println("<td>" + Datatable[0] + "</td>"); 
                                                    out.println("<td>" + Datatable[1] + "</td>");
                                                    out.println("<td>" + Datatable[2] + "</td>");
                                                    out.println("<td>" + Datatable[3] + "</td>");
                                                    out.println("<td>" + Datatable[4] + "</td>");
                                                    out.println("<td>" + Datatable[5] + "</td>");
                                                    
                                                   
                                                    out.println("</tr>");
                                                    out.println("</table>");
			 		
                                                                
                                                        
                                                        
                                           
                                                        
             	 	
	
            
        out.println("</table>");
        out.println("<form name='loginform' method='post' action='payment'>"
                + "<input type='submit' value='Make a payment'");
                
        out.println("</center></body>");
            out.println("</html>");
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(servlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(servlet.class.getName()).log(Level.SEVERE, null, ex);
        }}
        

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
   
    
}
    


