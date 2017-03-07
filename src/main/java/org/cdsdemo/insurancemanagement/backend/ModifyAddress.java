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

public class ModifyAddress extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger LOGGER = LoggerFactory.getLogger(ModifyAddress.class);
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		RequestDispatcher rd = req.getRequestDispatcher("/Common.jsp");
		rd.include(req,res);
		
		HttpSession ses1 = req.getSession(true);
		HttpSession ses2 = req.getSession(true);
		
		String logid = (String)ses1.getAttribute("logid");
		LOGGER.info("logid");
		
		String uid = (String)ses2.getAttribute("uid");
		LOGGER.info("login id..... "+logid);
		LOGGER.info("uid........."+uid);
			 
		PrintWriter pw = res.getWriter();
		pw.println("<html><title>Time Tracker</title><body>");
		
		String fname1 = req.getParameter("fname");
		LOGGER.info("fname"+fname1);
        
		String lname1 = req.getParameter("lname");
		LOGGER.info("lname"+lname1);
		
		String phone1 = req.getParameter("phone");
		LOGGER.info("phone"+phone1);		 
		
		String address1 = req.getParameter("address");
		LOGGER.info("address"+address1);
		
		String oaddress1 = req.getParameter("oaddress");
		LOGGER.info("oaddress"+oaddress1);
		
		String ophone1 = req.getParameter("ophone");
		LOGGER.info("ophone"+ophone1);     
	
		try {
			DBConnection dbcon = new DBGeneralImpl();
			Connection c = dbcon.getConnection();
			String s="update addressbook set fname='"+fname1+"',lname='"+lname1+"',phoneno="+phone1+",address='"+address1+"',officeadd='"+oaddress1+"',officephone="+ophone1+" where loginid='"+logid+"' and userid='"+uid+"'";
			LOGGER.info(s);
			
	    	PreparedStatement ps = c.prepareStatement(s);
	    	
			int j=ps.executeUpdate();          
			
			if (j==1) {
				pw.println("<body ><center><form><p><h3 ><font face=monospace color=pink>Your AddressBook Successfully Updated </h3></p>");
				pw.println("<input id=inputsubmit1 name=inputsubmit1 type=Button value=Back onClick=\"window.history.back()\"></form></center></body>");
			} else {
				pw.println("No modifications");
			}
            dbcon.close();
		} catch(Exception e) {
		    pw.println(e.toString());
			LOGGER.error("Error while modifying address :: ", e);
		}	
	}
		
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}
}

