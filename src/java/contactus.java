/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet(urlPatterns = {"/contactus"})
public class contactus extends HttpServlet {

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
    {
        try{
                PrintWriter out=response.getWriter();
                response.setContentType("text/html");
                out.write("<html><body>");
                out.write("<img src='banner10.jpg' width='100%' height='200'><hr>");
                out.write("<table width='100%'><tr><td><a href='index'>Home</a></td><td><a href='login'>Login</a></td><td><a href='feedetails'>Fee Details</a></td><td><a href='coursedetails'>Course Details</a></td><td><a href='contactus'>Contact Us</a></td></tr></table><hr>");
                out.write("<h1>CONTECT US</h1>");
                out.write(" <div class=\"node__content\">\n" +
                          "    \n" +
                          "            <div><p><strong>Institute of Engineering &amp; Technology,</strong><br />\n" +
                          "Resora, Sitapur<br />\n" +
                          "Uttar Pradesh<br />\n" +
                          "India<br />\n" +
                          "Pin Code          :   261001<br />\n" +
                          "Telephone No.  : 9838075059 <br />\n" +
                          "Fax No.            : +91-522-2361631</p>\n" +
                          "<img src='logo.png' style='display: block; margin-left: auto; margin-right: auto;' width='350px'>\n" +
                          "\n" +
                          "</div>\n" +
                          "      ");
                out.write("<hr><img src='footer10.png' width='100%'>");
                out.write("</body></html>");
        }catch(Exception ee){}
        
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
        processRequest(request, response);
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
