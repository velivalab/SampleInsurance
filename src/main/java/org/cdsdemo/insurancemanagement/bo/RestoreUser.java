package org.cdsdemo.insurancemanagement.bo;
 
 import org.cdsdemo.insurancemanagement.connection.DBGeneralImpl;

import org.cdsdemo.insurancemanagement.connection.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.sql.*;
 
 public class RestoreUser implements Serializable{
	 
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger LOGGER = LoggerFactory.getLogger(RestoreUser.class);
	   
    String uname;
    
    public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMailid() {
		return mailid;
	}

	public void setMailid(String mailid) {
		this.mailid = mailid;
	}

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	String passwd;
	String fname;
	String lname;
	String address;
	String phone;
	String mailid;
	String groupid;
	String branch;
       
    Connection con;
    Statement st;
    ResultSet rs;
    int i;
           
    DBConnection dbcon=new DBGeneralImpl();
       
    public int storeuser() throws SQLException{
	   try {  
		   LOGGER.info("in bean's method getuser"+uname);
		   con = dbcon.getConnection();
		   LOGGER.info("after Connection");
		   String sqlstmt = "update login set passwd='"+passwd+"',fname='"+fname+"',lname='"+lname+"',address='"+address+"',phone='"+phone+"',mailid='"+mailid+"',groupid='"+groupid+"',bname='"+branch+"' where userid='"+uname+"'";
		   LOGGER.info(sqlstmt);
		   st = con.createStatement();
		   i = st.executeUpdate(sqlstmt);
		   LOGGER.info("......No.Of Rows Updated"+i);      
	   } catch(Exception ex) {
		   LOGGER.error("Error while saving user details in DB :: ", ex);
	   } finally {
	        st.close();
	        con.close();
	   }
	   return i;
    }
               
    public String deluser(String username) throws SQLException{
	   try {              
		   LOGGER.info("in bean's method getuser"+uname);
		   con = dbcon.getConnection();
		   LOGGER.info("after Connection");
		   String sqlstmt = "delete from login where userid='"+username+"'";
		   LOGGER.info(sqlstmt);
		   st = con.createStatement();
		   i = st.executeUpdate(sqlstmt);
		   LOGGER.info("......No.Of Rows Deleted"+i);	      
	   } catch(Exception ex) {
		   LOGGER.error("Error while deleting user details from DB for user :: "+uname, ex);
	   } finally {
		   st.close();
	       con.close();
	   }
	   
	   return "userDeleted";     
    }

}




