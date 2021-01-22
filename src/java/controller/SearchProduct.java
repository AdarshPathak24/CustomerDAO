/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;

/**
 *
 * @author HP
 */
public class SearchProduct extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SearchProduct</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchProduct at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
            throws ServletException, IOException 
    {
        PrintWriter out=response.getWriter();
        
        try
        {     
   //     processRequest(request, response);
            
              out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SearchProduct</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
         int id;
        id=Integer.parseInt(request.getParameter("txtId"));
        ProductDAO pd=new ProductDAO();
        Product P;
        P=pd.searchById(id);
        if(P==null)
            out.println("<font color=red size=7>Record Not Found 404......</font>");
        else
        {
              out.println("<font color=blue size=4>Product Information......</font>");
              out.println("<font size=7>");
               out.println("<br>");
               out.println("<table border=1>");
               out.println("<tr><th>Product ID</th><th>Name</th><th>Price</th><th>Type</th></tr>");
               out.println("<tr>");
               out.println("<td>"+P.getId()+"</td>");
               out.println("<td>"+P.getName()+"</td>");
               out.println("<td>"+P.getPrice()+"</td>");
               out.println("<td>"+P.getType()+"</td>");
              out.println("</tr>");
              out.println("</table>");
            out.println("</font>");
             
        }
        
        
        }
        catch(Exception e)
        {
        
        }   
            out.println("</center>");
            out.println("</body>");
            out.println("</html>"); 
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
