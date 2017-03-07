package org.cdsdemo.insurancemanagement.backend;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.cdsdemo.insurancemanagement.connection.DBConnection;
import org.cdsdemo.insurancemanagement.connection.DBGeneralImpl;

public class Download extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger LOGGER = LoggerFactory.getLogger(Download.class);
   	 
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String fnames=null; 
		res.setContentType("application/download");
                
		try {
			HttpSession session=req.getSession(true);
			String gname=(String)session.getAttribute("group");
			String user=(String)session.getAttribute("user");
			
			DBConnection dbcon=new DBGeneralImpl();
			Connection c = dbcon.getConnection();
			Connection con = dbcon.getConnection();;
			PreparedStatement ps=null;
			Statement st=null;
			
			String filename=req.getParameter("finame");
			fnames=filename;
			LOGGER.info("the file name from servlet"+fnames);
			
			res.setHeader("Content-Disposition","attachment;filename="+fnames+"");
			LOGGER.info("headerset");
			
			if (gname.equals("user")) {
				ps=c.prepareStatement("select * from noticeboard where fname='"+filename+"'");
				st=con.createStatement();
			} else if(gname.equals("admin")){
				ps=c.prepareStatement("select * from download where fname='"+filename+"'");
				st=con.createStatement();
			}                 
                  
			ResultSet rs=ps.executeQuery();                   
			rs.next();

			Blob b11 = (Blob) rs.getObject(3);		
			LOGGER.info("the blob object received from database"+b11);
			
			InputStream fostream = b11.getBinaryStream();
			byte [] b10 = new byte[(int)b11.length()];
			int rebytes = fostream.read(b10);
			fostream.close();
  
			ServletOutputStream fistream = res.getOutputStream(); 
			fistream.write(b10);
			fistream.flush();
			
			LOGGER.info("successfuylly written");
			fistream.close();   
                                          
            String filestr=rs.getString("fname"); 
            LOGGER.info("fname is :: "+filestr);
			         
			dbcon.close();                 
		} catch(Exception e) {
            LOGGER.error("Error while downloading :: ", e);
		}
	}
		
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}
}

