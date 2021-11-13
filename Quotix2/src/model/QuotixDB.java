package model;

import java.sql.*;

public class QuotixDB {
    /*
     * Notes:
     * 
     * To Connect to the Database see information files in Teams
     * 
     */

    	public static final String URL = "jdbc:mysql://157.245.254.249:3306";
    	public static final String DATABASE_NAME = "quotix";
    	public static final String USER = "qTestUser"; // restricted permissions user
    	public static final String PASSWORD = "qTestPwd";

    	private static Connection connection = null;

    	public static Connection getConnection() throws ClassNotFoundException, SQLException {
    		if (connection != null)
    			return connection;

    		try {
    			connection = DriverManager.getConnection(URL + "/" + DATABASE_NAME, USER, PASSWORD);
    		} catch (Exception e) {
    			e.printStackTrace();
    			throw e;
    		}
    		return connection;

    	}

    	public void finalize() throws SQLException {
    		connection.close();
    	}
    	
    	
    }

