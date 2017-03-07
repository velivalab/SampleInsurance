package org.cdsdemo.insurancemanagement.connection;

import java.io.Serializable;
import java.sql.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBGeneralImpl implements DBConnection, Serializable {
    
	private static Logger LOGGER = LoggerFactory.getLogger(DBGeneralImpl.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DBGeneralImpl() {
			LOGGER.info("DBGeneralImpl constructor");
			init();
	}
	   
   	public void init() {
		  try{
				//Class.forName("oracle.jdbc.driver.OracleDriver");
				LOGGER.info("in init");
		  } catch(Exception ex){
			  LOGGER.error("Error while initializing the DB :: ", ex);
		  }
   	}

   	Connection con;
  
   	public Connection getConnection() {
   		LOGGER.info("Before getting the connection");
		  try {
			  	//Class.forName("oracle.jdbc.driver.OracleDriver");
			  	Class.forName("org.postgresql.Driver");
			  	LOGGER.info("driver loaded");
			  	
			  	//con = DriverManager.getConnection("jdbc:oracle:thin:@svec01:1521:ORCL","ect","ect");
			  	con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
			  	LOGGER.info("connection established");			  	
		  } catch(Exception ex){
			  LOGGER.error("Error while getting DB connection :: ", ex);
		  }
	  
		  return con;
   	}

   	public void close() {	          
		  try{
			  LOGGER.info("in close");
			  con.close();
		  } catch(Exception ex) {
			  LOGGER.error("Error while closing DB connection :: ", ex);
		  }
   	}
}