package org.cdsdemo.insurancemanagement.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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

public class DeleteMessage extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger LOGGER = LoggerFactory.getLogger(DeleteMessage.class);
	
    public void doPost(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        httpservletresponse.setContentType("text/html");
        PrintWriter printwriter = httpservletresponse.getWriter();
        printwriter.println("<html><title>Insurance Management Portal</title><body bgcolor=\"burlywood\">");
        String s = httpservletrequest.getParameter("receiver");
        LOGGER.info("ReceiverId" + s);
        String s1 = httpservletrequest.getParameter("date");
        LOGGER.info("date" + s1);
        String mid =httpservletrequest.getParameter("mid");
        LOGGER.info("mid" + mid);
        try
        {
        	DBConnection dbcon = new DBGeneralImpl();			
			Connection connection = dbcon.getConnection();			
            Statement statement = connection.createStatement();
            RequestDispatcher requestdispatcher = httpservletrequest.getRequestDispatcher("/Common.jsp");
            requestdispatcher.include(httpservletrequest, httpservletresponse);
            LOGGER.info("first");
            printwriter.println("<br><br><br><br><br><br><br>");
            printwriter.println("<table width='50%' border=1 BORDERCOLOR='#aqua'  name=t1 align='center' >");
            printwriter.println("<tr align='center'><td>");
            LOGGER.info("second");
            String s3 = "delete from messages where receiverid='" + s + "' and m_date=to_date('" + s1 + "','yyyy-mm-dd') and subject='" + mid + "'";
            LOGGER.info("third");
            LOGGER.info(s3);
            int i = statement.executeUpdate(s3);
            LOGGER.info("after update");
            if(i == 1) {
                printwriter.println("<form><h3> One Message Deleted</h3>");
                printwriter.println("<input type=Button value=Back onClick=\"window.history.back()\"></form>");
            }
            printwriter.println("</td></tr></table>");
            dbcon.close();
        } catch(Exception exception) {
        	// printwriter.println(exception.toString());
        	LOGGER.error("Error while deleting the message :: ",exception);
        }
    }
    
    public void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse) throws ServletException, IOException {
        doPost(httpservletrequest, httpservletresponse);
    }
}
