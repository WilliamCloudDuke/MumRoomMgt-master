package co.mum.roommgt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DatabaseConnectionFactory Description: Create connection to the database Last
 * Updated: 01/19/2018
 * 
 * @version 1.0 18 March 2018
 * @author William Chaparro
 */

public class DatabaseConnectionFactory {

	private static final Logger LOGGER = Logger.getLogger(DatabaseConnectionFactory.class.getName());
	private static final String DB_URL = "jdbc:mysql://172.19.141.166:3306/roommgt";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";

	public DatabaseConnectionFactory() {
		super();
		LOGGER.setLevel(Level.FINE);
	}

	/**
	 * Method to get Database connection from Database
	 * 
	 * @return Database connection object
	 */

	public static Connection createConnection() {
		System.out.println("--createConnection---");
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Error:" + "" + "" + " unable to load driver class!");
			LOGGER.fine("Error: unable to load driver class!");
			System.exit(1);
		}
		try {
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (SQLException e) {
			System.out.println("Error: While Creating connection to database");
			LOGGER.fine("Error: unable to load driver class!");
			System.exit(1);
		}
		return con;
	}

}
