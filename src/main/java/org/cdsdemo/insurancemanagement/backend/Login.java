package org.cdsdemo.insurancemanagement.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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

public class Login extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger LOGGER = LoggerFactory.getLogger(Login.class);

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
          doPost(req,res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {	    
		try {
            RequestDispatcher rd=req.getRequestDispatcher("./Common.jsp");
            rd.include(req,res);
          
            String groupid=null;
            String uname=null;
            String passwd=null;
            String dates=null;
            res.setContentType("text/html");
            PrintWriter out=res.getWriter();
            HttpSession session=req.getSession(true);
            String userId=req.getParameter("loginid");
            String password=req.getParameter("password");
          
            String chec=req.getParameter("chec");
            LOGGER.info("the val of radiobutton is"+chec);
            LOGGER.info("in LoginServlet");
         
            DBConnection dbcon = new DBGeneralImpl();
            Connection con = dbcon.getConnection();
            Statement st = con.createStatement();
            
            DBConnection connection = new DBGeneralImpl();
            Connection conn = connection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = st.executeQuery("select userid,passwd,groupid  from login where userid='"+userId+"'and passwd='"+password+"' and groupid='"+chec+"'");
            
            if (rs.next()) {
		           groupid=rs.getString("groupid");
		           LOGGER.info(groupid);
		           session.setAttribute("group",groupid);
		           uname=rs.getString("userid");
		           session.setAttribute("user",uname);
		           session.setAttribute("check",chec);
		           passwd=rs.getString("passwd");
                   
		           java.util.Calendar dd=java.util.Calendar.getInstance();
                   int date=dd.get(Calendar.DAY_OF_MONTH);
                   int month=dd.get(Calendar.MONTH)+1;
                   int year=dd.get(Calendar.YEAR);
                   int hr=dd.get(Calendar.HOUR_OF_DAY);
                   
                   int min=dd.get(Calendar.MINUTE);
                   dates=""+date+"/"+month+"/"+year+":"+hr+":"+min;
    
                   if("user".equalsIgnoreCase(groupid)) {                     
                	   LOGGER.info("in if loop"+uname+passwd+groupid+dates);
                	   stmt.executeUpdate("update login set lastused_date_time=to_date('"+dates+"','dd/mm/yyyy:hh24:mi') where userid='"+uname+"'and passwd='"+passwd+"'and groupid='"+groupid+"' ");
                	   res.sendRedirect("main.html");                  
                   } else if("admin".equalsIgnoreCase(groupid)) {
                	   LOGGER.info("in admin loop"+uname+passwd+groupid+dates);
                	   stmt.executeUpdate("update login set lastused_date_time=to_date('"+dates+"','dd/mm/yyyy:hh24:mi') where userid='"+uname+"'and passwd='"+passwd+"' and groupid='"+groupid+"' ");                                 
                	   res.sendRedirect("admin.htm");
                   }
            } else {
                   out.println("u are not a valid user");
                   out.println("<a href=./login.htm>Login</a>");
            }      
		} catch(SQLException e){
			LOGGER.error("Error while login :: ",e);
		}
	}
}