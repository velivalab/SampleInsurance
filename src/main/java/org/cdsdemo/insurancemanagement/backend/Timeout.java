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
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.cdsdemo.insurancemanagement.connection.DBConnection;
import org.cdsdemo.insurancemanagement.connection.DBGeneralImpl;

public class Timeout extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger LOGGER = LoggerFactory.getLogger(Timeout.class);
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("<html><title>Timeand Work Management</title><body>");
        RequestDispatcher rd=req.getRequestDispatcher("/Common.jsp");
        rd.include(req,res);
		HttpSession session =req.getSession(true);
		String user=req.getParameter("user");
		LOGGER.info("user"+user);
        
		String dateone=req.getParameter("dateone");
		LOGGER.info("dateone"+dateone);
		
		String hour=req.getParameter("hour");
		LOGGER.info("hour"+hour); 
        
		String min=req.getParameter("min");
		LOGGER.info("min"+min); 
        
		String datetwo=dateone+":"+hour+":"+min;
        LOGGER.info("the date before par...........sing from String "+datetwo);
 
        try {   
                DBConnection dbcon = new DBGeneralImpl();
                Connection con = dbcon.getConnection();
                  
                PreparedStatement pstmt = con.prepareStatement("insert into logout values(?,to_date(?,'dd/mm/yyyy:hh:mi'))");
                pstmt.setString(1,user);
                pstmt.setString(2,datetwo);
                
                int i=pstmt.executeUpdate();
                LOGGER.info("Rows Updated"+i);

                if (i==1) {
                	pw.println("<form><h3> '"+user+"' u r Logout Time Is Stored</h3>");
                	pw.println("<input type=Button value=Back onClick=\"window.history.back()\"></form>");
                }
           } catch (Exception e) {
                pw.println("<form><h3>");
                pw.println(e);
                pw.println("</h3>");
                     
                pw.println("<input type=Button value=Back onClick=\"window.history.back()\"></form>");
              	LOGGER.error("Error during timeout :: ", e);
           }		
	}
		
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}
}

