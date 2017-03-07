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

public class StoreWorkLog extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger LOGGER = LoggerFactory.getLogger(StoreWorkLog.class);
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("<html><title>Timeand Work Management</title><body>");
        RequestDispatcher rd=req.getRequestDispatcher("/Common.jsp");
        rd.include(req,res);
		HttpSession session =req.getSession(true);
		String date=req.getParameter("dc");
		LOGGER.info("date"+date);
        String task=req.getParameter("task");
		LOGGER.info("task"+task);
		String time=req.getParameter("time");
		LOGGER.info("time"+time);

        String user=(String)session.getAttribute("user");
        LOGGER.info("user"+user);
		
		try {			
			DBConnection dbcon = new DBGeneralImpl();
			Connection c = dbcon.getConnection();

            PreparedStatement st=c.prepareStatement("insert into worklog values(?,to_date(?,'dd/mm/yyyy'),?,?)");
            st.setString(1,user);
            st.setString(2,date);
            st.setString(3,time);
			st.setString(4,task);
                  
            int lk = st.executeUpdate();
			LOGGER.info(".......No.Of Rows Updated........."+lk);
				
			
			if (lk==1) {
				pw.println("<form><h3>" +user+ " u r WorkDetails Are Stored</h3>");
				pw.println("<input type=Button value=Back onClick=\"window.history.back()\"></form>");
			}
            dbcon.close();
		} catch(Exception e) {
		    pw.println(e.toString());
            LOGGER.error("Error while saving the work log details :: ", e);
		}	
	}
		
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}
}

