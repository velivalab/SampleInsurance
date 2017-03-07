package org.cdsdemo.insurancemanagement.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

public class LeaveDetails extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger LOGGER = LoggerFactory.getLogger(LeaveDetails.class);
   	 
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("<html><title>Timeand Work Management</title><body>");
        RequestDispatcher rd=req.getRequestDispatcher("./Common.jsp");
        rd.include(req,res);

		HttpSession session = req.getSession(true);
		String user=req.getParameter("user");
		LOGGER.info("user"+user);
        String purpose=req.getParameter("purpose");
		LOGGER.info("purpose"+purpose);
		String month=req.getParameter("month");
		LOGGER.info("month"+month); 
        String day=req.getParameter("day");
		LOGGER.info("day"+day); 
        String year=req.getParameter("year");
		LOGGER.info("year"+year); 
        String tomonth=req.getParameter("tomonth");
		LOGGER.info("tomonth"+tomonth);   
        String today=req.getParameter("today");
		LOGGER.info("today"+today);                                
		String toyear=req.getParameter("toyear");
		LOGGER.info("year"+toyear); 
        String dateone=month+"/"+day+"/"+year; 
        String datetwo=tomonth+"/"+today+"/"+toyear;
        LOGGER.info("the date before par...........sing from String "+dateone);
 
        try {
        	Calendar cal = Calendar.getInstance();
        	cal.set(Calendar.DATE, Integer.parseInt(day));
        	cal.set(Calendar.MONTH, Integer.parseInt(month));
            cal.set(Calendar.YEAR, Integer.parseInt(year));
            
            java.util.Date d1 = cal.getTime();
            
            Calendar cal1 = Calendar.getInstance();
        	cal1.set(Calendar.DATE, Integer.parseInt(today));
        	cal1.set(Calendar.MONTH, Integer.parseInt(tomonth));
            cal1.set(Calendar.YEAR, Integer.parseInt(toyear));
            
            java.util.Date d2 = cal1.getTime();            
           
            int diff = calculateDifference(d1,d2);                
            LOGGER.info("the difference between two dates"+diff);            
                                   
            DBConnection dbcon = new DBGeneralImpl();
            Connection con = dbcon.getConnection();
                  
            PreparedStatement pstmt = con.prepareStatement("insert into leaves values(?,?,to_date(?,'mm/dd/yyyy'),to_date(?,'mm/dd/yyyy'),?)");
            pstmt.setString(1,user);
            pstmt.setString(2,purpose);
            pstmt.setString(3,dateone);
            pstmt.setString(4,datetwo);
            pstmt.setInt(5,diff);
            
            int i=pstmt.executeUpdate();
            LOGGER.info("Rows Updated"+i);

            if (i==1) {
				pw.println("<form><h3> Values Are Inserted</h3>");
				pw.println("<input type=Button value=Back onClick=\"window.history.back()\"></form>");
			}               
        } catch(Exception e){
			pw.println("<form><h3>");
			pw.println(e);
			pw.println("</h3>");			     
			pw.println("<input type=Button value=Back onClick=\"window.history.back()\"></form>");
			LOGGER.error("Error while inserting leave details :: ", e);
        }
	}
		
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}

	//start
	public static int calculateDifference(java.util.Date a, java.util.Date b){   
		 int tempDifference = 0;
		 int difference = 0;  
	     Calendar earlier = Calendar.getInstance();
		 Calendar later = Calendar.getInstance(); 
		 
		 if (a.compareTo(b) < 0) {
		        earlier.setTime(a); 
		       later.setTime(b);    
		} else {  
	          	earlier.setTime(b); 
		       	later.setTime(a);    
		}
		 
		while (earlier.get(Calendar.YEAR) != later.get(Calendar.YEAR)) {    
			tempDifference = 365 * (later.get(Calendar.YEAR) - earlier.get(Calendar.YEAR));
			difference += tempDifference;  
			earlier.add(Calendar.DAY_OF_YEAR, tempDifference);
	    }
		
	    if (earlier.get(Calendar.DAY_OF_YEAR) != later.get(Calendar.DAY_OF_YEAR)) {
	    	tempDifference = later.get(Calendar.DAY_OF_YEAR) - earlier.get(Calendar.DAY_OF_YEAR);        
	    	difference += tempDifference;
	        earlier.add(Calendar.DAY_OF_YEAR, tempDifference); 
	    }
	    
		return difference;
	}
	//end
}

