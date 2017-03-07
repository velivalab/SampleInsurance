package org.cdsdemo.insurancemanagement.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

public class StoreGroupMessage extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger LOGGER = LoggerFactory.getLogger(StoreGroupMessage.class);
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int j = 0;
		res.setContentType("text/html");
        RequestDispatcher rd=req.getRequestDispatcher("/Common.jsp");
        rd.include(req,res);
		PrintWriter pw=res.getWriter();
		pw.println("<html><title>Timeand Work Management</title><body>");
		
		String SenderId=req.getParameter("sender");
		LOGGER.info("sender"+SenderId);
        
		String groupid=req.getParameter("groupid");
		LOGGER.info("groupid"+groupid);
		
		String date=req.getParameter("date");
		LOGGER.info("date"+date);
		
		String subject=req.getParameter("subject");
		LOGGER.info("subject"+subject);
		
		String content1=req.getParameter("content");
		LOGGER.info("content"+content1);   
		
		try {
			DBConnection dbcon=new DBGeneralImpl();
			Connection c = dbcon.getConnection();
            Statement st=c.createStatement();
            ResultSet rs=st.executeQuery("select userid from groupusers where groupid='"+groupid+"'");
            
            while(rs.next()) {
	    		PreparedStatement ps=c.prepareStatement("insert into messages values(?,?,to_date(?,'dd-mm-yyyy'),?,?)");
	    		ps.setString(1,SenderId);
	    		ps.setString(2,rs.getString("userid"));
	    		ps.setString(3,date);
	    		ps.setString(4,subject);
	    		ps.setString(5,content1);
			
	    		j=ps.executeUpdate();
			}
           
			if (j>0) {
				pw.println("<form><h3> Message Stored</h3>");
				pw.println("<input type=Button value=Back onClick=\"window.history.back()\"></form>");
			}
            dbcon.close();
		} catch(Exception e) {
		    pw.println(e.toString());
		    LOGGER.error("Error while storing the group message :: ", e);
		}	
	}
		
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}
}

