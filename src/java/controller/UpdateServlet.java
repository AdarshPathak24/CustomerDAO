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
public class UpdateServlet extends HttpServlet {

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
            out.println("<title>Servlet UpdateServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateServlet at " + request.getContextPath() + "</h1>");
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
            throws ServletException, IOException {
         PrintWriter out = response.getWriter();
        try
        {     
        
         out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateServlet</title>");            
            out.println("</head>");
            out.println("<body>");
             int id;
             id=Integer.parseInt(request.getParameter("txtId"));
             ProductDAO pd=new ProductDAO();
             Product P;
             P=pd.searchById(id);
             
                out.println("<center>");
                out.println("<table border=1>");
                out.println("<form method=post action=FinalUpdate>");
               out.println("<tr>");
               out.println("<th>Product ID</th>");
               out.println("<td><input type=text name=txtId value="+P.getId()+"></td>");
               out.println("</tr>");
               out.println("<tr>");
               out.println("<th>Product Name</th>");
               out.println("<td><input type=text name=txtName value="+P.getName()+"></td>");
               out.println("</tr>");
               out.println("<tr>");
               out.println("<th>Product Price</th>");
               out.println("<td><input type=text name=txtPrice value="+P.getPrice()+"></td>");
               out.println("</tr>");
               out.println("<tr>");
               out.println("<th>Product Type</th>");
               out.println("<td><input type=text name=txtType value="+P.getType()+"></td>");
               out.println("</tr>");
               out.println("<tr>");
               out.println("<th></th>");
               out.println("<td><input type=submit value=Update></td>");
               out.println("</tr>");
                out.println("</form>");
                out.println("</table>");
                out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e)
        {
          out.println(e);
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
