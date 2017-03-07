package org.cdsdemo.insurancemanagement.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.cdsdemo.insurancemanagement.connection.DBConnection;
import org.cdsdemo.insurancemanagement.connection.DBGeneralImpl;

public class StoreSchedule extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger LOGGER = LoggerFactory.getLogger(StoreSchedule.class);
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("<html><title>Time and Work Management</title><body>");
           		
		String name=req.getParameter("name");
		LOGGER.info("--------------name"+name);
        
		String schedule=req.getParameter("schedule");
		LOGGER.info("-----------schedule"+schedule);
		
		String user=req.getParameter("sel");
		LOGGER.info(user);
            
        LOGGER.info("sel"+user);
        LOGGER.info("atlast");
		
		try {
			DBConnection dbcon=new DBGeneralImpl();
			Connection c = dbcon.getConnection();
            Statement st=c.createStatement();
            String query="insert into schedular  values('"+user+"','"+name+"','"+schedule+"')";
                    
            LOGGER.info(query);
            int lk=st.executeUpdate(query);
			LOGGER.info(".......No.Of Rows Updated........."+lk);
						
			if (lk==1) {
				LOGGER.info("inside if");
				
				pw.println("<html>");
				pw.println("<body ><center>");
				pw.println("<br><br>");
				pw.println("<link href=\"default1.css\" rel=\"stylesheet\" type=\"text/css\" />");
				pw.println("<center><form align='center'><h3 color='pink'> Schedule Details for "+user+" Are Stored</h3></center><br><br>");
				pw.println("<center><a href=\"schedular.jsp\"><font color='white'>Give Another Schedule</font></a></center>");
				pw.println("</body></html>");
				LOGGER.info(user+ " u r Schedule Details Are Stored");				
			}
            dbcon.close();
		} catch(Exception e) {
		    pw.println(e.toString());
		    LOGGER.error("Error while saving the schedule details :: ", e);
		}
	}
		
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}
}

