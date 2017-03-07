package org.cdsdemo.insurancemanagement.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.cdsdemo.insurancemanagement.connection.DBConnection;
import org.cdsdemo.insurancemanagement.connection.DBGeneralImpl;

public class OpenAddressBook extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger LOGGER = LoggerFactory.getLogger(OpenAddressBook.class);
   	 
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		LOGGER.info("inopenaddressbokkkkk");
		pw.println("<html><title>Timeand Work Management</title><body><form action=./modiadd>");
		RequestDispatcher rd=req.getRequestDispatcher("./Common.jsp");
		rd.include(req,res);
		
		String userid=req.getParameter("userid");
		HttpSession ses1=req.getSession();
		ses1.setAttribute("logid",userid);
		LOGGER.info("userid"+userid);
		String mailid=req.getParameter("mailid");
		HttpSession ses2=req.getSession();
		ses2.setAttribute("uid",mailid);
		LOGGER.info("mailid"+mailid);		         
		
		try {
			DBConnection dbcon = new DBGeneralImpl();
			Connection c = dbcon.getConnection();
            Statement st = c.createStatement();
         
			pw.println("<br><br><br><br>");
			pw.println("<table width='50%' border=1 BORDERCOLOR='pink'  name=t1 align='center' >");
			pw.println("<tr><td>");
			
			String laks="select * from addressbook where loginid='"+userid+"' and userid='"+mailid+"'";
			
			ResultSet rs =st.executeQuery(laks);
		
			while (rs.next()) {
                    pw.println("<font color='pink'><tr align='center'><td>");
                    pw.println("Fname:");
                    String fname=rs.getString("fname");
                    pw.println("</td><td>");
                    pw.println("<input type=text name='fname' value='"+fname+"'>");
                    pw.println("</td></tr>"); 
                    pw.println("<tr align='center'><td>");
                    pw.println("Lname:");
                    pw.println("</td><td>");
                    String lname=rs.getString("lname");

                    pw.println("<input type=text name='lname' value='"+lname+"'>");
                    pw.println("</td></tr>"); 
                    pw.println("<tr align='center'><td>");
                    pw.println("mailid:");
                    pw.println("</td><td>");
                    String mail=rs.getString("userid");

                    pw.println("<input type=text name='mailid' value='"+mail+"'>");
                    pw.println("</td></tr>");
                    pw.println("<tr align='center'><td>");
                    pw.println("phone:");
                    pw.println("</td><td>");
                    String phone=rs.getString("phoneno");

                    pw.println("<input type=text name='phone' value='"+phone+"'>");
                    pw.println("</td></tr>");  
                    pw.println("<tr align='center'><td>");
                    pw.println("address:");
                    pw.println("</td><td>");
                    pw.println(" <TEXTAREA id='address' name='address'>");
                    pw.println(rs.getString("address"));
                    pw.println("</TEXTAREA> ");
                    pw.println("</td></tr>"); 
                    pw.println("<tr align='center'><td>");
                    pw.println("WorkInfo:");
                    pw.println("</td></tr>");
                    pw.println("<tr align='center'><td>");
                    pw.println("OfficeAddress:");
                    pw.println("</td><td>");
                    pw.println(" <TEXTAREA id='oaddress' name='oaddress'>");
                    pw.println(rs.getString("officeadd"));
                    pw.println("</TEXTAREA> ");
                    pw.println("</td></tr>"); 
                    pw.println("<tr align='center'><td>");
                    pw.println("OfficePhone:");
                    pw.println("</td><td>");
                    String ophone=rs.getString("officephone");

                    pw.println("<input type=text name='ophone' value='"+ophone+"'>");
                    pw.println("</td></tr>");
            }
            pw.println("</td></tr></table></font>");
            pw.println("<input type=submit value=Modify  name=modify>");

            pw.println("<input type=Button id='inputsubmit1' value=Back onClick=\"window.history.back()\"></form>");

			dbcon.close();
		} catch(Exception e) {
		    pw.println(e.toString());
		    LOGGER.error("Error while opening address book :: ", e);
		}
	
		pw.println("</form></body></html>");
	}
		
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}
}

