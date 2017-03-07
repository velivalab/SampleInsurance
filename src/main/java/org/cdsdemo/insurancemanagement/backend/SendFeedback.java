package org.cdsdemo.insurancemanagement.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.cdsdemo.insurancemanagement.connection.DBConnection;
import org.cdsdemo.insurancemanagement.connection.DBGeneralImpl;

public class SendFeedback extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger LOGGER = LoggerFactory.getLogger(SendFeedback.class);
 
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("<html><title>Timeand Work Management</title><body>");
        
		RequestDispatcher rd=req.getRequestDispatcher("/Common.jsp");
        rd.include(req,res);
		
        String user=req.getParameter("user");
		LOGGER.info("user"+user);
        
		String fdate=req.getParameter("fdate");
		LOGGER.info("fdate"+fdate);
		
		String time=req.getParameter("time");
		LOGGER.info("time"+time);
		
		String subject=req.getParameter("subject");
		LOGGER.info("subject"+subject);
		
		String comments=req.getParameter("comment");
		LOGGER.info("comments"+comments);
		
		try {
			DBConnection dbcon = new DBGeneralImpl();
			Connection c = dbcon.getConnection();
                    
	    	PreparedStatement ps = c.prepareStatement("insert into feedback values(?,to_date(?,'dd-mm-yyyy'),?,?,?)");

			ps.setString(1,user);
	    	ps.setString(2,fdate);
			ps.setString(3,time);
			ps.setString(4,subject);
			ps.setString(5,comments);
			
			int j = ps.executeUpdate();
			           
			if (j==1) {
				pw.println("<form><h3> Values Are Inserted</h3>");
			}
            dbcon.close();
		} catch(Exception e) {
		    pw.println(e.toString());
		    LOGGER.error("Error while sending the feedback :: ", e);
		}	
	}
		
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}
}

