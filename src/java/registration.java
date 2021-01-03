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
import java.sql.*;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Administrator
 */
@WebServlet(urlPatterns = {"/registration"})
public class registration extends HttpServlet {

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
                Class.forName("org.gjt.mm.mysql.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1/FeesManagement","root","");
                PreparedStatement stmt;
                ResultSet rs;
                String msg="";
                if(request.getParameter("b1")!=null)
                {
                    String s1=request.getParameter("t1");
                    String s2=request.getParameter("t2");
                    String s3=request.getParameter("t3");
                    String s4=request.getParameter("t4");
                    String s5=request.getParameter("t5");
                    String s6=request.getParameter("t6");
                    String s7=request.getParameter("t7");
                    String s8=request.getParameter("t8");
                    String s9=request.getParameter("t9");
                    String s10=request.getParameter("t10");
                    String s11=request.getParameter("t11");
                    String s12=request.getParameter("t12");
                    String s13=request.getParameter("t13");
                    String s14=request.getParameter("t14");
                    String s15=request.getParameter("t15");
                    stmt=con.prepareStatement("Insert into Students values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    stmt.setString(1,s1);
                    stmt.setString(2,s2);
                    stmt.setString(3,s3);
                    stmt.setString(4,s4);
                    stmt.setString(5,s5);
                    stmt.setString(6,s6);
                    stmt.setString(7,s7);
                    stmt.setString(8,s8);
                    stmt.setString(9,s9);
                    stmt.setString(10,s10);
                    stmt.setString(11,s11);
                    stmt.setString(12,s12);
                    stmt.setString(13,s13);
                    stmt.setString(14,s14);
                    stmt.executeUpdate();
                    stmt=con.prepareStatement("Insert into Users values(?,?,'student')");
                    stmt.setString(1,s3);
                    stmt.setString(2,s15);
                    stmt.executeUpdate();
                    msg="Registration Completed";
                }
                PrintWriter out=response.getWriter();
                response.setContentType("text/html");
                out.write("<html><body>");
                out.write("<img src='banner10.jpg' width='100%' height='200'><hr>");
                out.write("<table width='100%'><tr><td><a href='admin'>Home</a></td><td><a href='fee'>Fee</a></td><td><a href='registration'>Student Registration</a></td><td><a href='logout'>Logout</a></td><td></td></tr></table><hr>");
                out.write("<form method=post>");
                out.write("<table align=center>");
                out.write("<tr><td>Roll No.:</td><td><input type='text' name='t1'></td></tr>");
                out.write("<tr><td>Name:</td><td><input type='text' name='t2'></td></tr>");
                out.write("<tr><td>Email:</td><td><input type='email' name='t3'></td></tr>");
                out.write("<tr><td>Password:</td><td><input type='password' name='t15'></td></tr>");
                out.write("<tr><td>Father:</td><td><input type='text' name='t4'></td></tr>");
                out.write("<tr><td>Mother:</td><td><input type='text' name='t5'></td></tr>");
                out.write("<tr><td>Address:</td><td><textarea name='t6'></textarea></td></tr>");
                out.write("<tr><td>State:</td><td><select name='t7'>");
                stmt=con.prepareStatement("Select distinct states from indianstates");
                rs=stmt.executeQuery();
                while(rs.next())
                {
                    out.write("<option>"+rs.getString(1)+"</option>");
                }
                out.write("</select></td></tr>");
                out.write("<tr><td>City:</td><td><select name='t8'>");
                stmt=con.prepareStatement("Select distinct city from indianstates where city is not null order by city");
                rs=stmt.executeQuery();
                while(rs.next())
                {
                    out.write("<option>"+rs.getString(1)+"</option>");
                }
                out.write("</select></td></tr>");
                out.write("<tr><td>Pin Code:</td><td><input type='text' name='t9'></td></tr>");
                out.write("<tr><td>Mobile:</td><td><input type='text' name='t10'></td></tr>");
                out.write("<tr><td>Course:</td><td><select name='t11'><option>B.Tech.</option><option>B.Arch.</option><option>MCA</option><option>MBA</option></select></td></tr>");
                out.write("<tr><td>Date of Birth:</td><td><input type='date' name='t12'></td></tr>");
                out.write("<tr><td>Admission Date:</td><td><input type='date' name='t13'></td></tr>");
                out.write("<tr><td>Total Fees:</td><td><input type='text' name='t14'></td></tr>");
                out.write("<tr><td></td><td><font color=red>"+msg+"</font></td></tr>");
                out.write("<tr><td></td><td><input type='submit' value='Register' name='b1'></td></tr>");
                out.write("</table>");
                out.write("</form>");
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
