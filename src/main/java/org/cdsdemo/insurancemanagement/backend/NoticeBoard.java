package org.cdsdemo.insurancemanagement.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

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

public class NoticeBoard extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger LOGGER = LoggerFactory.getLogger(NoticeBoard.class);
   	 
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
        HttpSession session =req.getSession(true);
        String group=(String)session.getAttribute("group");
		PrintWriter pw=res.getWriter();
        RequestDispatcher rd=req.getRequestDispatcher("./Common.jsp");
        rd.include(req,res);
		pw.println("<html><title>Timeand Work Management</title><body>");
		
		String loginid=(String)session.getAttribute("user");  
		LOGGER.info("Notice Board for user : "+loginid);
		
		try {
			LOGGER.info("hello");
			
			DBConnection dbcon=new DBGeneralImpl();
			Connection c = dbcon.getConnection();
                                
	    	PreparedStatement ps=null;
            if("user".equalsIgnoreCase(group)){
               LOGGER.info("i");
               ps=c.prepareStatement("select * from noticeboard");
            } else {
        	   LOGGER.info("e");
               ps=c.prepareStatement("select * from download");
            }
                
            pw.println("<p ><H3 align='center'color=pink><u>DOWNLOAD&nbspFILES</u></H3></p>");
            pw.println("<table WIDTH='50%' align='center' border='2' bordercolor='pink'> ");
            pw.println("<tr><td><font color='pink'>Sender</font</td><td><font color='pink'>Date</font></td><td><font color='pink'>FileName</font></td></tr></font>");
	
            ResultSet rs=ps.executeQuery();
			
            while(rs.next()) {
	              pw.println("<tr><td>");
	              pw.println(rs.getString(1));      
	              pw.println("</td><td>");
	              java.sql.Date d1 = rs.getDate(4);
	             	             	              
	              Calendar cal = Calendar.getInstance();
	              cal.setTimeInMillis(d1.getTime());
	              String datetwo = ""+cal.get(Calendar.DATE)+"/"+cal.get(Calendar.MONTH)+"/"+cal.get(Calendar.YEAR);
	              LOGGER.info("the datetwo is*********"+datetwo);
	              pw.println(datetwo);    
	              pw.println("</td><td>");
	              pw.println("<a href=\"./download?finame="+rs.getString(2)+"\">"+rs.getString(2)+"</a>"); 
	              pw.println("</td></tr>");
	        }
	        pw.println("</table>");
           
			dbcon.close();
		} catch(Exception e) {
		    pw.println(e.toString());
            LOGGER.error("Exception while notice board :: ", e);
		}	
	}
		
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}
}

