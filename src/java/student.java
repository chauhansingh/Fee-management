/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
@WebServlet(urlPatterns = {"/student"})
public class student extends HttpServlet {

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
                HttpSession hs=request.getSession(false);
                if(hs==null) response.sendRedirect("login");
                PrintWriter out=response.getWriter();
                response.setContentType("text/html");
                out.write("<html><body>");
                out.write("<img src='banner10.jpg' width='100%' height='200'><hr>");
                out.write("<table width='100%'><tr><td><a href='logout'>Logout</a></td><td></td><td></td><td></td><td></td></tr></table><hr>");
                Class.forName("org.gjt.mm.mysql.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1/FeesManagement","root","");
                PreparedStatement stmt;
                ResultSet rs;
                stmt=con.prepareStatement("Select * from Students where Email=?");
                stmt.setString(1,hs.getValue("UEMAIL")+"");
                rs=stmt.executeQuery();
                if(rs.next())
                {
                    String rollno=rs.getString(1);
                    out.write("<table align=center>");
                    out.write("<tr><td>Roll No.:</td><td>"+rollno+"</td></tr>");
                    out.write("<tr><td>Name:</td><td>"+rs.getString(2)+"</td></tr>");
                    out.write("<tr><td>Email:</td><td>"+rs.getString(3)+"</td></tr>");
                    out.write("<tr><td>Father:</td><td>"+rs.getString(4)+"</td></tr>");
                    out.write("<tr><td>Mother:</td><td>"+rs.getString(5)+"</td></tr>");
                    out.write("<tr><td>Address:</td><td>"+rs.getString(6)+"</td></tr>");
                    out.write("<tr><td>State:</td><td>"+rs.getString(7)+"</td></tr>");
                    out.write("<tr><td>City:</td><td>"+rs.getString(8)+"</td></tr>");
                    out.write("<tr><td>Pin Code:</td><td>"+rs.getString(9)+"</td></tr>");
                    out.write("<tr><td>Mobile:</td><td>"+rs.getString(10)+"</td></tr>");
                    out.write("<tr><td>Course:</td><td>"+rs.getString(11)+"</td></tr>");
                    out.write("<tr><td>Date of Birth:</td><td>"+rs.getString(12)+"</td></tr>");
                    out.write("<tr><td>Admission Date:</td><td>"+rs.getString(13)+"</td></tr>");
                    out.write("<tr><td>Total Fees:</td><td>"+rs.getString(14)+"</td></tr>");
                    out.write("</table>");
                    out.write("<hr>");
                out.write("<center><h3>Fee Details Submitted by the Students</h3><center>");
                stmt=con.prepareStatement("Select * from FeeDetails where rollno=?");
                stmt.setString(1,rollno);
                rs=stmt.executeQuery();
                out.write("<hr>");
                out.write("<table align=center>");
                out.write("<tr><th>Roll No</th><th>Date</th><th>Amount</th><th>Mode of Payment</th><th>Details</th></tr>");
                while(rs.next())
                {
                    String s1=rs.getString(1);
                    String s2=rs.getString(2);
                    String s3=rs.getString(3);
                    String s4=rs.getString(4);
                    String s5=rs.getString(5);
                    out.write("<tr style='background:#FFEECC'>");
                    out.write("<td>"+s1+"</td>");
                    out.write("<td>"+s2+"</td>");
                    out.write("<td>"+s3+"</td>");
                    out.write("<td>"+s4+"</td>");
                    out.write("<td>"+s5+"</td>");
                    out.write("</tr>");                    
                }
                out.write("</table>");
                }
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
