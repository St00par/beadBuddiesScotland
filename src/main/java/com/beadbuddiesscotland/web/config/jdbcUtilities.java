package com.beadbuddiesscotland.web.config;

import java.io.InputStream;

//import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class jdbcUtilities {

//	public static void exUpdate(String query) {
//    	try {
//    		jdbcConnector.stmnt.executeUpdate(query);
//    	} catch (SQLException e) {
//    		e.printStackTrace();
//    	}
//    }
//    public ResultSet exQuery(String query) {
//    	ResultSet response = null;
//    	try {
//    		response = jdbcConnector.stmnt.executeQuery(query);
//    	} catch (SQLException e) {
//    		e.printStackTrace();
//    	}
//    	return response;
//}	
	private final String dbUrl;

	private final String dbUser;

	private final String dbPassword;

	private jdbcUtilities(String properties) {
			Properties dbProps = new Properties();
			try (InputStream fis = ClassLoader.getSystemResourceAsStream(properties)) {
				dbProps.load(fis);
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.dbUrl = dbProps.getProperty("db.url","");
			this.dbUser = dbProps.getProperty("db.username","");
			this.dbPassword = dbProps.getProperty("db.password","");
		}

		public jdbcUtilities() {
			this("db.properties");
		}

		public Connection getConnection() throws SQLException {
			return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		}

		private static jdbcUtilities instance;

		public static jdbcUtilities connect() {
			instance = new jdbcUtilities();
			return instance;
		}

		public static jdbcUtilities connect(String properties) {
			instance = new jdbcUtilities(properties);
			return instance;
		}

		public static jdbcUtilities getInstance() {
			if (instance == null) {
				instance = new jdbcUtilities();
			}
			return instance;
		}
}