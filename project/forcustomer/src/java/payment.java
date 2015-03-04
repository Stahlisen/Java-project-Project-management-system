/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import PayaLot.CreditCard;
import PayaLot.Payment;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fredrik
 */
public class payment extends HttpServlet {
    
    String projectid;
    float costConverted;
    float calculatedCost;
    float percentage = (float) 0.1;
    
    String notice;
    String paynotice;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

 

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
       
        String cardnr = request.getParameter("cardnr");
        String cardowner = request.getParameter("owner");
        String cardtype = request.getParameter("cards");
        databaseconnection newCost = new databaseconnection();
        servlet a = new servlet();
        
        projectid = servlet.projectid;
        System.out.println("Projectid: " + projectid);
        String cost = null;
        try {
            cost = newCost.getprojectCost(projectid);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(payment.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(cardnr);
        System.out.println(cardowner);
        System.out.println(cardtype);
        costConverted = Float.parseFloat(cost);
        calculatedCost = costConverted * percentage;
        String theCost = Float.toString(calculatedCost);
        System.out.println(calculatedCost);
        String product = "1/10 projectcost";
        
        
        
        
        
        
       
        
        try {
            CreditCard newCard = new CreditCard(cardowner, cardnr, cardtype);
            notice = newCard.notice();
            System.out.println(notice);
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(payment.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Payment newPayment = new Payment(cardnr, cardowner, theCost, product );
            paynotice = newPayment.notice();
            System.out.println(paynotice);
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(payment.class.getName()).log(Level.SEVERE, null, ex);
        }
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet payment transaction completed</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h1>" + notice + "</h1>");
            out.println("<h1>" + paynotice + "</h1>");
            out.println("</center>");
    
    
   
    
            
         
            out.println("</body>");
            out.println("</html>");
       
                
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet payment</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h1>Make a 10% payment off the project</h1>");
            out.println("<h2> Payment information </h2>");
        out.println("<form name='loginform' method='get' action='payment'>");
    out.println("Card number: <input type='text' name='cardnr'><br>");
    out.println("Name: <input type='text' name='owner'><br>");
    
    out.println("<select name='cards'>" + 
"<option value='Visa'>Visa</option>" + 
"<option value='Master Card'>Mastercard</option>" + 
"</select>");
    out.println("<br><input type=\"submit\" value=\"Pay\">");
    out.println("</form>");
    out.println("</center>");
    
    
   
    
            
         
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}



