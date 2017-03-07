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

public class StoreContact extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger LOGGER = LoggerFactory.getLogger(StoreContact.class);
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
        RequestDispatcher rd = req.getRequestDispatcher("/Common.jsp");
        rd.include(req,res);
        HttpSession session = req.getSession(true);
		PrintWriter pw = res.getWriter();
		pw.println("<html><title>Timeand Work Management</title><body>");
		String fname=req.getParameter("fname");
		LOGGER.info("fname"+fname);
        String lname=req.getParameter("lname");
		LOGGER.info("lname"+lname);
		String phone=req.getParameter("phone");
		LOGGER.info("phone"+phone);
		String mailid=req.getParameter("mailid");
		LOGGER.info("mailid"+mailid);
		String address=req.getParameter("address");
		LOGGER.info("address"+address);
		String oaddress=req.getParameter("oaddress");
		LOGGER.info("oaddress"+oaddress);
		String ophone=req.getParameter("ophone");
		LOGGER.info("ophone"+ophone);
		String loginid=(String)session.getAttribute("user");
		
		try {
			DBConnection dbcon = new DBGeneralImpl();
			Connection c = dbcon.getConnection();
	    	
			PreparedStatement ps = c.prepareStatement("insert into addressbook values(?,?,?,?,?,?,?,?)");
			ps.setString(1,loginid);
	    	ps.setString(2,mailid);
			ps.setString(3,fname);
			ps.setString(4,lname);
			ps.setString(5,address);
			ps.setString(6,phone);
			ps.setString(7,oaddress);
			ps.setString(8,ophone);
			int j=ps.executeUpdate();
			if (j==1) {
				pw.println("<form><p><h3 align='center'> Successfully Added To Your AddressBook</h3></p>");
				pw.println("<input type=Button id='inputsubmit1' value=Back onClick=\"window.history.back()\"></form>");
			}
            dbcon.close();
		} catch(Exception e) {
		    pw.println(e.toString());
		    LOGGER.error("Error while storing the contact :: ", e);
		}
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}
}

