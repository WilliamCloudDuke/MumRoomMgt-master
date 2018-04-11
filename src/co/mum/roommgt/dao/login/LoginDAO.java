/**
 * 
 */
package co.mum.roommgt.dao.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import co.mum.roommgt.model.Account;
import co.mum.roommgt.model.ROLE_TYPE;
import co.mum.roommgt.util.DBUtil;
import co.mum.roommgt.util.DatabaseConnectionFactory;

/**
 * LoginDAO Description: 01/19/2018
 * 
 * @version 1.0 18 March 2018
 * @author William Chaparro
 */
public class LoginDAO {

	private ResourceBundle rb;
	private static final Logger LOGGER = Logger.getLogger(DatabaseConnectionFactory.class.getName());
	private static final String BUNDLE_PATH = "co.mum.roommgt.dao.login.bundle.login";

	public LoginDAO() {
		super();
		LOGGER.setLevel(Level.FINE);
		rb = ResourceBundle.getBundle(BUNDLE_PATH);
	}

	/**
	 * 
	 * 
	 * 
	 * @param String
	 *            username
	 * @return boolean expression
	 */
	public boolean isValidUser(String username, String password) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = DatabaseConnectionFactory.createConnection();
			pst = con.prepareStatement(rb.getString("isValidUser"));
			pst.setString(1, username);
			pst.setString(2, password);
			rs = pst.executeQuery();
			int i = 0;
			while (rs.next()) {
				i = 1;
			}
			if (i != 0) {
				return true;
			}
		} catch (SQLException sqle) {
			LOGGER.fine("Error: method isValidUser method!");
		} finally {
			DBUtil.closePreparedStatement(pst);
			DBUtil.closeResultSet(rs);
			DBUtil.closeConnection(con);
		}
		return false;
	}

	/**
	 * 
	 * 
	 * 
	 * @param String
	 *            username
	 * 
	 * @return userType
	 */
	public Account getAccount(String username, String password) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Account account = null;
		try {
			con = DatabaseConnectionFactory.createConnection();
			pst = con.prepareStatement(rb.getString("getAccount"));
			pst.setString(1, username);
			rs = pst.executeQuery();
			if (rs.next()) {
				int roleType = rs.getInt(1);
				String buildingNumber = rs.getString(2);
				switch (roleType) {
				case 1:
					if (null != buildingNumber && !buildingNumber.equals("")) {
						account = new Account(username, password, ROLE_TYPE.RESIDENT_ADVISOR,
								Integer.parseInt(buildingNumber));
					} else {
						account = new Account(username, password, ROLE_TYPE.RESIDENT_ADVISOR);
					}
					break;
				case 2:
					if (null != buildingNumber && !buildingNumber.equals("")) {
						account = new Account(username, password, ROLE_TYPE.RESIDENT_DIRECTOR,
								Integer.parseInt(buildingNumber));
					} else {
						account = new Account(username, password, ROLE_TYPE.RESIDENT_DIRECTOR);
					}
					break;
				case 3:
					if (null != buildingNumber && !buildingNumber.equals("")) {
						account = new Account(username, password, ROLE_TYPE.STUDENT, Integer.parseInt(buildingNumber));
					} else {
						account = new Account(username, password, ROLE_TYPE.STUDENT);
					}
					break;
				}
			}
		} catch (SQLException sqle) {
			LOGGER.fine("Error: method getAccount method!");
		} finally {
			DBUtil.closePreparedStatement(pst);
			DBUtil.closeResultSet(rs);
			DBUtil.closeConnection(con);
		}
		return account;
	}

}
