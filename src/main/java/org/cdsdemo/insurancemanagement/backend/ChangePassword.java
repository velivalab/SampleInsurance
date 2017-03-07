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
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.cdsdemo.insurancemanagement.connection.DBConnection;
import org.cdsdemo.insurancemanagement.connection.DBGeneralImpl;

public class ChangePassword extends HttpServlet {   	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger LOGGER = LoggerFactory.getLogger(ChangePassword.class);

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("./Common.jsp");
		rd.include(req,res);
		res.setContentType("text/html");
		
		PrintWriter pw = res.getWriter();
		pw.println("<html><title>Time and Work Management</title><body>");
		
		HttpSession session = req.getSession(true);
		
		String cpwd = req.getParameter("cpwd");
		LOGGER.info("cpwd"+cpwd);
		
		String rpwd = req.getParameter("rpwd");
		LOGGER.info("rpwd"+rpwd);
		
		String user = (String)session.getAttribute("user");
		LOGGER.info("user"+user);
		
		String group = (String)session.getAttribute("group");
		
		try
		{
			DBConnection dbcon = new DBGeneralImpl();
			
			Connection c;
			c = dbcon.getConnection();
			
			Statement st = c.createStatement();
			
			String query = "update login set passwd='"+cpwd+"' where userid='"+user+"'and groupid='"+group+"'";
			LOGGER.info(query);
			
			int lk = st.executeUpdate(query);
			LOGGER.info(".......No.Of Rows Updated........."+lk);
				
			
			if (lk == 1) {
				pw.println("<form><h3>" +user+ " u r Password Has Been Changed</h3>");
				pw.println("<input type=Button value=Back onClick=\"window.history.back()\"></form>");
			}
            dbcon.close();
		} catch(Exception e) {
		    pw.println(e.toString());
            LOGGER.error("Error while changing the password :: ", e);
		}
	}
		
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}
}

