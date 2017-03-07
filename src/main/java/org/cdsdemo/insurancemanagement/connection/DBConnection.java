package org.cdsdemo.insurancemanagement.connection;

import java.sql.Connection;

public interface DBConnection {
	public void init();
	public Connection getConnection();
	public void close();    
}

