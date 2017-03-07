package org.cdsdemo.insurancemanagement.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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

public class StoreWorkReport extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger LOGGER = LoggerFactory.getLogger(StoreWorkReport.class);
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("<html><title>Timeand Work Management</title><body>");
        RequestDispatcher rd=req.getRequestDispatcher("/Common.jsp");
        rd.include(req,res);
		HttpSession session =req.getSession(true);
		String from=req.getParameter("from");
		LOGGER.info("fromdate"+from);
        String use=req.getParameter("use");
		LOGGER.info("use"+use);

        String to=req.getParameter("to");
		LOGGER.info("todate"+to);
        String user=(String)session.getAttribute("user");
        LOGGER.info("user"+user);          
		LOGGER.info("included2");
		
		try {
			DBConnection dbcon=new DBGeneralImpl();
			Connection c = dbcon.getConnection();
            Statement st=c.createStatement();
            String query="select slottime,to_char(w_date,'dd/mm/yyyy'),tasks from worklog where userid='"+use+"' and w_date between to_date('"+from+"','dd-mm-yyyy') and  to_date('"+to+"','dd-mm-yyyy')";
            LOGGER.info(query);
            ResultSet rs=st.executeQuery(query);
            pw.println("<br><br><table width='90%'align='center' border='1'>");
            pw.print("<b>WORKREPORT OF   ");
            pw.println(use);
            pw.println("<b>");
            pw.println("<tr><td align='center'>Time</td><td align='center'>Date</td><td align='center'>Tasks</td></tr>");
             
            while (rs.next()) {
            	 pw.println("<tr><td align='center'>"+rs.getString(1)+"</td>");
                 pw.println("<td align='center'>"+rs.getString(2)+"</td>");
                 pw.println("<td align='center'>"+rs.getString(3)+"</td></tr>");
            }
            pw.println("<tr></table>");
            dbcon.close();
		} catch(Exception e) {
		    pw.println(e.toString());
		    LOGGER.error("Error while saving the work report details :: ", e);
		}
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}
}