package org.cdsdemo.insurancemanagement.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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

public class AddUser extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger LOGGER = LoggerFactory.getLogger(AddUser.class);
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		res.setContentType("text/html");
		HttpSession session =req.getSession(true);
		PrintWriter pw=res.getWriter();
		RequestDispatcher rd=req.getRequestDispatcher("./Common.jsp");
		rd.include(req,res);
		pw.println("<html><title>Time and Work Management</title><body>");
		String userid=(String)session.getAttribute("userid");
		LOGGER.info("userid"+userid);
		//String user1=userid;
        String passwd=req.getParameter("password");
		LOGGER.info("passwd"+passwd);
		String fname=req.getParameter("fname");
		LOGGER.info("fname"+fname);
		String lname=req.getParameter("lname");
		LOGGER.info("lname"+lname);
		String address=req.getParameter("address");
		LOGGER.info("address"+address);
		String phone=req.getParameter("phone");
		LOGGER.info("phone"+phone);
		String mailid=req.getParameter("mailid");
		LOGGER.info("mailid"+mailid);
        String groupid=req.getParameter("groupid");
		LOGGER.info("groupid"+groupid);
        String branch=req.getParameter("branch");
		LOGGER.info("branch"+branch);
      	
		String loginid = (String)session.getAttribute("userid");
      	
        int j=0;
		
        try {
			DBConnection dbcon=new DBGeneralImpl();
			Connection c;
			c = dbcon.getConnection();
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("select userid from login where userid='"+userid+"'");
			
            if (rs.next()) {
            	pw.println("Userid   "+userid+" already Existed");
            } else {
            	java.util.Calendar dd=java.util.Calendar.getInstance();
				int date=dd.get(Calendar.DAY_OF_MONTH);
				int month=dd.get(Calendar.MONTH)+1;
				int year=dd.get(Calendar.YEAR);
				int hour=dd.get(Calendar.HOUR);
				int min=dd.get(Calendar.MINUTE);
				
                String dates=""+date+"/"+month+"/"+year+":"+hour+":"+min;
	    		
                PreparedStatement ps=c.prepareStatement("insert into login values(?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy:hh24:mi'),to_date(?,'dd/mm/yyyy:hh24:mi'),?)");
				ps.setString(1,userid);
		  		ps.setString(2,passwd);
				ps.setString(3,fname);
				ps.setString(4,lname);
				ps.setString(5,address);
				ps.setString(6,phone);
				ps.setString(7,mailid);
				ps.setString(8,groupid);
	            ps.setString(9,dates);
	            ps.setString(10,dates);
	            ps.setString(11,branch);
				 j=ps.executeUpdate();
			}//end of else
           	
            if (j==1) {			
				pw.println("<form><h3><font color='pink'> Values Are Inserted</font></h3>");
				pw.println("<input type=Button id='inputsubmit1' value=Back onClick=\"window.history.back()\"></form>");
			}
            
            dbcon.close();
		} catch(Exception e) {
		    pw.println(e.toString());
		    LOGGER.error("Error while adding user :: ", e);
		}
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}
}

