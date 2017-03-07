package org.cdsdemo.insurancemanagement.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

public class CreateGroup extends HttpServlet
{ 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger LOGGER = LoggerFactory.getLogger(CreateGroup.class);
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		pw.println("<html><title>Timeand Work Management</title><body>");
		RequestDispatcher rd = req.getRequestDispatcher("./Common.jsp");
		rd.include(req,res);
		
		String gname = req.getParameter("gname");
		LOGGER.info("gname"+gname);
		
		String user = req.getParameter("user");
		LOGGER.info("user"+user);
		
		try {	
			int j = 0;
			DBConnection dbcon = new DBGeneralImpl();
			
			Connection c;
			c = dbcon.getConnection();
			
            Statement st = c.createStatement();
            String query = "select * from groupusers where groupid='"+gname+"' and userid='"+user+"'";
            LOGGER.info(query);
            
            ResultSet rs = st.executeQuery(query);
			LOGGER.info("................"+rs);
			
			if (rs.next()) {
				pw.println("the user is already added in to this group");
			} else {
	    		PreparedStatement ps = c.prepareStatement("insert into groupusers values(?,?)");
			    ps.setString(1,gname);
	    		ps.setString(2,user);
			    j = ps.executeUpdate();
           	}
			
			if (j==1) {
				pw.println("<form><h3> Values Are Inserted</h3>");
				pw.println("<input type=Button value=Back onClick=\"window.history.back()\"></form>");
			}
            dbcon.close();
		} catch(Exception e)
		{
		    pw.println(e.toString());
		    LOGGER.error("Error while creating group :: ", e);
		}
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}
}