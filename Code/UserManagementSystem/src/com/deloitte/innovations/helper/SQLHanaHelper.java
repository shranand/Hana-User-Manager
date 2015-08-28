package com.deloitte.innovations.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLHanaHelper implements SQLHelper {
	Connection con;

	public SQLHanaHelper(String host, String port, String tech_username, String tech_pwd) {
		super();
		
		try {//System.out.println("URL IS:" + "jdbc:sap://"+ host +":"+ port +"/?autocommit=false");
		    //con = DriverManager.getConnection("jdbc:sap://hana01.dev.dci.local:30015/?autocommit=false", "Username", "password");
		    con = DriverManager.getConnection("jdbc:sap://"+ host +":"+ port +"/?autocommit=false", tech_username, tech_pwd);
		} catch (SQLException e) {
		    System.err.println("SQLHanaHelper: Connection Failed. User/Passwd Error?");
		    //return;
		}

		
		
	}
	
	
	public ResultSet execute(String query)throws SQLException,ClassNotFoundException {
        
        Statement stmt = con.createStatement();
        
        ResultSet rs=null;
        rs=stmt.executeQuery(query);
        return rs;
        }
	
	
	public void commit(String query){}
	
	
	public void closeConnection() throws SQLException {
        System.out.println("Closing Connection ...");
        if (isConnectionOpen()) {
            con.close();
            con = null;
        }
    }
    public boolean isConnectionOpen() {
        return (con != null);
    }


    public void executeUpdate(String query) throws SQLException,ClassNotFoundException {
        
        Statement stmt = con.createStatement();
        stmt.execute(query);
       
    }
	
	

}
