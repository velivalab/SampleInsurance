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

public class StoreMeeting extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger LOGGER = LoggerFactory.getLogger(StoreMeeting.class);
   	 
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("<html><title>Timeand Work Management</title><body>");
        RequestDispatcher rd=req.getRequestDispatcher("/Common.jsp");
        rd.include(req,res);
		
        String mdate=req.getParameter("mdate");
		LOGGER.info("mdate"+mdate);
        
		String time=req.getParameter("time");
		LOGGER.info("time"+time);
		
		String purpose=req.getParameter("purpose");
		LOGGER.info("purpose"+purpose);
		
		String issue=req.getParameter("issue");
		LOGGER.info("issue"+issue);
		
		String conclusion=req.getParameter("conclusion");
		LOGGER.info("conclusion"+conclusion);
		
		try {
			DBConnection dbcon=new DBGeneralImpl();
			Connection c = dbcon.getConnection();
            String test="insert into meetings values(to_date(?,'dd-mm-yyyy'),?,?,?,?)";
                    
	    	PreparedStatement ps=c.prepareStatement(test);

			ps.setString(1,mdate);
	    	ps.setString(2,time);
			ps.setString(3,purpose);
			ps.setString(4,issue);
			ps.setString(5,conclusion);
			int j=ps.executeUpdate();
			
			if (j==1) {
				pw.println("<form><h3> Details Are Stored</h3>");
				pw.println("<input type=Button value=Back onClick=\"window.history.back()\"></form>");
			}
            dbcon.close();
		} catch(Exception e) {			
		    pw.println(e.toString());
		    LOGGER.error("Error while storing the meeting details :: ", e);
		}
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}
}

