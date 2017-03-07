package org.cdsdemo.insurancemanagement.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.cdsdemo.insurancemanagement.connection.DBConnection;
import org.cdsdemo.insurancemanagement.connection.DBGeneralImpl;

public class DeleteAddress extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger LOGGER = LoggerFactory.getLogger(DeleteAddress.class);

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("<html><title>Timeand Work Management</title><body bgcolo>");
		RequestDispatcher rd=req.getRequestDispatcher("./Common.jsp");
		rd.include(req,res);
		
		String userid=req.getParameter("userid");
		LOGGER.info("userid"+userid);
		String mailid=req.getParameter("mailid");
		LOGGER.info("mailid"+mailid);
		
		try {
			DBConnection dbcon = new DBGeneralImpl();
			Connection c;
            c = dbcon.getConnection();
            Statement st = c.createStatement();
        
			pw.println("<br><br><br><br><br><br><br>");
			pw.println("<table width='50%' border=1 BORDERCOLOR='#aqua'  name=t1 align='center' >");
			pw.println("<tr align='center'><td>");
			String laks = "delete from addressbook where loginid='"+userid+"' and userid='"+mailid+"'";
			int j = st.executeUpdate(laks);

			if (j==1) {
				pw.println("<form><h3> One Message Deleted</h3>");
				pw.println("<input type=Button value=Back onClick=\"window.history.back()\"></form>");
			}
			pw.println("</td></tr></table>");
			dbcon.close();
		} catch(Exception e) {
		    pw.println(e.toString());
		    LOGGER.error("Error while deleting address :: ", e);
		}	
	}
		
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}
}

