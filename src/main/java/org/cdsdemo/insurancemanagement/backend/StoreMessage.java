package org.cdsdemo.insurancemanagement.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

public class StoreMessage extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger LOGGER = LoggerFactory.getLogger(StoreMessage.class);
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("<html><title>Timeand Work Management</title><body>");
        RequestDispatcher rd=req.getRequestDispatcher("/Common.jsp");
        rd.include(req,res);
        
		String SenderId=req.getParameter("sender");
		LOGGER.info("sender"+SenderId);
        
		String receiver=req.getParameter("receiver");
		LOGGER.info("receiver"+receiver);
		
		String date=req.getParameter("date");
		LOGGER.info("date"+date);
		
		String subject=req.getParameter("subject");
		LOGGER.info("subject"+subject);
		
		String content1=req.getParameter("content");
		LOGGER.info("content"+content1);
		
		try {
			DBConnection dbcon=new DBGeneralImpl();
			Connection c = dbcon.getConnection();
            LOGGER.info("Got db connection to save the message details");
            
	    	PreparedStatement ps=c.prepareStatement("insert into messages values(?,?,to_date(?,'dd-mm-yyyy'),?,?)");
            LOGGER.info("bye");
			ps.setString(1,SenderId);
	    	ps.setString(2,receiver);
			ps.setString(3,date);
			ps.setString(4,subject);
			ps.setString(5,content1);
						
			int j=ps.executeUpdate();
			           
			if (j==1) {
				pw.println("<form><h3 align='center'> Your Message Has Been Sent to '"+receiver+"'</h3>");
				pw.println("<input type=Button value=Back onClick=\"window.history.back()\"></form>");
			}
            dbcon.close();
		} catch(Exception e) {
		    pw.println(e.toString());
		    LOGGER.error("Error while saving the message details ::" , e);
		}	
	}
		
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}
}

