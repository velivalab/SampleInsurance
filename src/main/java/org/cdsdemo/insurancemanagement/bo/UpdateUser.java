 package org.cdsdemo.insurancemanagement.bo;
 
 import org.cdsdemo.insurancemanagement.connection.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.sql.*;
 
 public class UpdateUser implements Serializable {
	 
	private static Logger LOGGER = LoggerFactory.getLogger(UpdateUser.class);
	
	String passwd;
	String fname;
	String lname;
	String address;
	String phone;
	String mailId;
	String groupId;
	String branch;
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}
               
	Connection con;
	Statement st;
	ResultSet rs;
               
    DBConnection dbcon=new DBGeneralImpl();
    
    public void getuser(String uname) throws SQLException {
    	try {
			   this.uname = uname;
			   LOGGER.info("in bean's method getuser"+uname);
			   
			   con = dbcon.getConnection();
			   LOGGER.info("after Connection");
			   
			   String sqlstmt="select * from login where userid='"+uname+"'";
			   LOGGER.info(sqlstmt);
			   
			   st = con.createStatement();
			   rs = st.executeQuery(sqlstmt);
			   LOGGER.info("after executing the statement");
			   
			   while (rs.next()) {
					LOGGER.info("in resultset");
					uname = rs.getString("userid");
					
					LOGGER.info(uname);
					
					passwd = rs.getString("passwd");
					LOGGER.info(passwd);

					fname = rs.getString("fname");
					LOGGER.info(fname);
					
					lname = rs.getString("lname");
					LOGGER.info(lname);
					
					address = rs.getString("address");
					LOGGER.info(address);
					
					phone = rs.getString("phone");
					LOGGER.info(phone);

					mailId = rs.getString("mailId");
					LOGGER.info(mailId);

					groupId = rs.getString("groupId");
					LOGGER.info(groupId);
 
					branch = rs.getString("bname");
					LOGGER.info(branch);
			   }
    	} catch(Exception ex){
    		LOGGER.error("Error while updating user details from DB for user :: "+uname, ex);
    	} 
    }
}




