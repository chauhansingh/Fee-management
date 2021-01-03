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
@WebServlet(urlPatterns = {"/fee"})
public class fee extends HttpServlet {

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
                    String ss1=request.getParameter("t1");
                    java.util.Date d=new java.util.Date();
                    String ss2=(d.getYear()+1990)+"-"+(d.getMonth()+1)+"-"+d.getDate();
                    String ss3=request.getParameter("t2");
                    String ss4=request.getParameter("t3");
                    String ss5=request.getParameter("t4");
                    stmt=con.prepareStatement("Insert into Feedetails values(?,?,?,?,?)");
                    stmt.setString(1,ss1);
                    stmt.setString(2,ss2);
                    stmt.setString(3,ss3);
                    stmt.setString(4,ss4);
                    stmt.setString(5,ss5);
                    stmt.executeUpdate();
                    msg="Fee Submitted";
                }
                PrintWriter out=response.getWriter();
                response.setContentType("text/html");
                out.write("<html><body>");
                out.write("<img src='banner10.jpg' width='100%' height='200'><hr>");
                out.write("<table width='100%'><tr><td><a href='admin'>Home</a></td><td><a href='fee'>Fee</a></td><td><a href='registration'>Student Registration</a></td><td><a href='logout'>Logout</a></td><td></td></tr></table><hr>");
                out.write("<form method=post>");
                out.write("<table align=center>");
                String ss1="",ss2="",ss3="",ss4="",ss5="";
                if(request.getQueryString()!=null)
                {
                    String s=request.getParameter("rollno");
                    stmt=con.prepareStatement("Select * from students where rollno=?");
                    stmt.setString(1,s);
                    rs=stmt.executeQuery();
                    if(rs.next())
                    {
                        ss1=rs.getString("rollno");
                        ss2=rs.getString("name");
                        ss3=rs.getString("father");
                        ss4=rs.getString("course");
                        ss5=rs.getString("totalfees");
                        out.write("<tr><td>Roll No:</td><td><input type='text' name='t1' value='"+ss1+"' readonly></td></tr>");
                        out.write("<tr><td>Name:</td><td>"+ss2+"</td></tr>");
                        out.write("<tr><td>Father:</td><td>"+ss3+"</td></tr>");
                        out.write("<tr><td>Course:</td><td>"+ss4+"</td></tr>");
                        out.write("<tr><td>Total Fees:</td><td>"+ss5+"</td></tr>");
                        out.write("<tr><td>Fee Submitted:</td><td><input type='text' name='t2'></td></tr>");
                        out.write("<tr><td>Mode of Payment:</td><td><input type='text' name='t3'></td></tr>");
                        out.write("<tr><td>Comment:</td><td><input type='text' name='t4'></td></tr>");
                        out.write("<tr><td></td><td><input type='submit' value='Submit Fee' name=b1></td></tr>");
                    }
                }
                out.write("<tr><td></td><td><font color=red>"+msg+"</font></td></tr>");
                out.write("</table></form>");
                stmt=con.prepareStatement("Select * from students");
                rs=stmt.executeQuery();
                out.write("<hr>");
                out.write("<table align=center>");
                while(rs.next())
                {
                    String s1=rs.getString("rollno");
                    String s2=rs.getString("name");
                    String s3=rs.getString("email");
                    String s4=rs.getString("father");
                    String s5=rs.getString("mobile");
                    String s6=rs.getString("course");
                    String s7=rs.getString("TotalFees");
                    out.write("<tr style='background:#CCFFAA'>");
                    out.write("<td>"+s1+"</td>");
                    out.write("<td>"+s2+"</td>");
                    out.write("<td>"+s3+"</td>");
                    out.write("<td>"+s4+"</td>");
                    out.write("<td>"+s5+"</td>");
                    out.write("<td>"+s6+"</td>");
                    out.write("<td>"+s7+"</td>");
                    out.write("<td><a href='fee?rollno="+s1+"'>Show Details</a></td>");
                    out.write("</tr>");                    
                }
                out.write("</table>");
                stmt=con.prepareStatement("Select sum(FeePaid),RollNo from FeeDetails group by RollNo");
                rs=stmt.executeQuery();
                out.write("<hr>");
                out.write("<center><h3>Fee Submitted by the Students</h3><center>");
                out.write("<hr>");
                out.write("<table align=center>");
                out.write("<tr><th>Roll No</th><th>Fee Submitted</th></tr>");
                while(rs.next())
                {
                    String s1=rs.getString(2);
                    String s2=rs.getString(1);
                    out.write("<tr style='background:#FFCCEE'>");
                    out.write("<td>"+s1+"</td>");
                    out.write("<td>"+s2+"</td>");
                    out.write("</tr>");                    
                }
                out.write("</table>");
                out.write("<hr>");
                out.write("<center><h3>Fee Details Submitted by the Students</h3><center>");
                stmt=con.prepareStatement("Select * from FeeDetails");
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
                out.write("<hr><img src='footer10.png' width='100%'>");
                out.write("</body></html>");
        }catch(Exception ee){System.out.println(ee);}
        
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
