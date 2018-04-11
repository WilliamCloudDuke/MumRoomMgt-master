package co.mum.roommgt.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DBUtil Description: Handle Database objects Updated: 01/19/2018
 * 
 * @version 1.0 18 March 2018
 * @author William Chaparro
 */
public class DBUtil {

	private static final Logger LOGGER = Logger.getLogger(DBUtil.class.getName());

	public DBUtil() {
		super();
		LOGGER.setLevel(Level.FINE);
	}

	public static void closeStatement(Statement st) {
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException sqle) {
			LOGGER.fine("Error: unable to close statement!");
		}
	}

	public static void closePreparedStatement(PreparedStatement pst) {
		try {
			if (pst != null) {
				pst.close();
			}
		} catch (SQLException sqle) {
			LOGGER.fine("Error: unable to close prepated statement!");
		}
	}

	public static void closeResultSet(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException sqle) {
			LOGGER.fine("Error: unable to close resultSet!");
		}
	}

	public static void closeConnection(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException sqle) {
			LOGGER.fine("Error: unable to close connection!");
		}
	}

}
