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
@WebServlet(urlPatterns = {"/login"})
public class login extends HttpServlet {

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
                String s=request.getQueryString();
                if(s==null)
                    s="";
                else
                    s="Invalid Login/Password!!!!";
                out.write("<html><body>");
                out.write("<img src='banner10.jpg' width='100%' height='200'><hr>");
                out.write("<table width='100%'><tr><td><a href='index'>Home</a></td><td><a href='login'>Login</a></td><td><a href='feedetails'>Fee Details</a></td><td><a href='coursedetails'>Course Details</a></td><td><a href='contactus'>Contact Us</a></td></tr></table><hr>");
                out.write("<form method=post action='dologin'>");
                out.write("<table align='center'>");
                out.write("<tr><td>Login:</td><td><input type='text' name='t1'></td></tr>");
                out.write("<tr><td>Password:</td><td><input type='password' name='t2'></td></tr>");
                out.write("<tr><td></td><td><input type='checkbox' name='c1'> Remember Me</td></tr>");
                out.write("<tr><td></td><td><input type='submit' name='b1' value='Login'></td></tr>");
                out.write("<tr><td></td><td><font color=red>"+s+"</font></td></tr>");
                out.write("</table></form>");                        
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
