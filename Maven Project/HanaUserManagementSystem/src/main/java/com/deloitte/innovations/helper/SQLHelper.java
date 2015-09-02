package com.deloitte.innovations.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface SQLHelper {
	
	
	public ResultSet execute(String query) throws SQLException, ClassNotFoundException;
	public void commit(String query);
	public void executeUpdate(String query) throws SQLException, ClassNotFoundException;
	

}



