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

public class StoreNews extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger LOGGER = LoggerFactory.getLogger(StoreNews.class);
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String dates=null;
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("<html><title>Timeand Work Management</title><body>");
        RequestDispatcher rd=req.getRequestDispatcher("/Common.jsp");
        rd.include(req,res);
		
        HttpSession session =req.getSession(true);
		String news=req.getParameter("news");
		LOGGER.info("news"+news);
        String user=(String)session.getAttribute("user");
        LOGGER.info("user"+user);
        
        try {
            	DBConnection dbcon=new DBGeneralImpl();
            	Connection c = dbcon.getConnection();
                
            	java.util.Calendar dd = java.util.Calendar.getInstance();
                int date = dd.get(Calendar.DAY_OF_MONTH);
                int month = dd.get(Calendar.MONTH) + 1;
                int year = dd.get(Calendar.YEAR);
                int min = dd.get(Calendar.MINUTE);                       
                
                int hr = dd.get(Calendar.HOUR);
                if (hr>=13) {
                   hr = hr-12;
                }
                if (hr==00) {
                   hr = 12;
                }
                LOGGER.info("===================="+hr);
                dates = ""+date+"/"+month+"/"+year+":"+hr+":"+min;
                PreparedStatement st=c.prepareStatement("insert into news values(to_date(?,'dd/mm/yyyy:hh:mi'),?)");
                st.setString(1,dates);
                st.setString(2,news);
                
                int lk=st.executeUpdate();
                LOGGER.info(".......No.Of Rows Updated........."+lk);
			
                if (lk==1) {
                	pw.println("<form><h3><font color=pink>The News is Entered Into Database</font></h3>");;
                }
                dbcon.close();
		} catch(Exception e) {
		    pw.println(e.toString());
            LOGGER.error("Error while saving the news :: ", e);
		}
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}
}

