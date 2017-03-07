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
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.cdsdemo.insurancemanagement.connection.DBConnection;
import org.cdsdemo.insurancemanagement.connection.DBGeneralImpl;

public class BranchDetails extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger LOGGER = LoggerFactory.getLogger(BranchDetails.class);
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session =req.getSession(true);
		
		String user = (String)session.getAttribute("user");
		String group = (String)session.getAttribute("group");
		LOGGER.info(user+group);
		
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		RequestDispatcher rd = req.getRequestDispatcher("./Common.jsp");
		rd.include(req, res);

		if ("admin".equalsIgnoreCase(group)) {
			pw.println("<html><title>Time and Work Management</title><body>");
			
			String bcode = req.getParameter("bcode");
			LOGGER.info("bcode"+bcode);
			String bname = req.getParameter("bname");
			LOGGER.info("bname"+bname);
			
			try {
				DBConnection dbcon=new DBGeneralImpl();
				Connection c;
				
				c = dbcon.getConnection();
				Statement st = c.createStatement();
				
				String query="insert into branch values('"+bcode+"','"+bname+"')";
				LOGGER.info(query);
				
				int lk = st.executeUpdate(query);
				LOGGER.info(".......No.Of Rows Updated........."+lk);

				if (lk == 1) {
					pw.println("<form><h3 color=pink>NEW BRANCH ADDED</h3>");
					pw.println("<input id=inputsubmit1 type=Button value=Back onClick=\"window.history.back()\"></form>");
				}
				
	            dbcon.close();
			} catch(Exception e) {
			    pw.println(e.toString());              
			}
        } else {
            pw.println("u are not valid user to view this page");     
        }
	}
		
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		doPost(req,res);
	}
}

