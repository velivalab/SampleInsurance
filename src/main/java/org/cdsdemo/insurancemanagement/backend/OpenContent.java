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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.cdsdemo.insurancemanagement.connection.DBConnection;
import org.cdsdemo.insurancemanagement.connection.DBGeneralImpl;

public class OpenContent extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger LOGGER = LoggerFactory.getLogger(OpenContent.class);
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
        RequestDispatcher rd = req.getRequestDispatcher("/Common.jsp");
        rd.include(req,res);
		pw.println("<html><title>Time and Work Management</title><body bgcolor=\"burlywood\">");
		String ReceiverId = req.getParameter("receiver");
		LOGGER.info("ReceiverId"+ReceiverId);
        String date = req.getParameter("date");
		LOGGER.info("date"+date);
		String mid = req.getParameter("mid");
		LOGGER.info("mid"+mid);        
		
		try {
			DBConnection dbcon=new DBGeneralImpl();			
            Connection c = dbcon.getConnection();
            Statement st = c.createStatement();
         
            pw.println("<br><br><br><br><br><br><br>");
            pw.println("<table width='50%' border=1 BORDERCOLOR='#aqua'  name=t1 align='center' >");
            pw.println("<tr align='center'><td>");
            
            String laks = "select message from messages where receiverid='"+ReceiverId+"' and subject='"+mid+"' ";
            
            ResultSet rs = st.executeQuery(laks);		
	
			while (rs.next()) {
					pw.println("Message");
                    pw.println("<TEXTAREA rows='15' cols='40' id='content' name='content'  readonly='readonly'>");
                    pw.println(rs.getString(1));
                    pw.println("</TEXTAREA> ");                  
            }
			
			pw.println("</td></tr></table><br>");
			pw.println("<center><input type=Button id='inputsubmit1' value=Back onClick=\"window.history.back()\"></form></center>");

			dbcon.close();
		} catch(Exception e) {
		    pw.println(e.toString());
		    LOGGER.error("Error while opening the content :: ", e);
		}
	}
		
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}
}

