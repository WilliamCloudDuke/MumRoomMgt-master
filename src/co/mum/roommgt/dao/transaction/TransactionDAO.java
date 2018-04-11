package co.mum.roommgt.dao.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * LoginDAO Description: 01/19/2018
 * 
 * @version 1.0 18 March 2018
 * @author Joseph Kelly Tusoy
 */

import co.mum.roommgt.model.Student;
import co.mum.roommgt.model.Transaction;
import co.mum.roommgt.util.DBUtil;
import co.mum.roommgt.util.DatabaseConnectionFactory;

public class TransactionDAO {

	private ResourceBundle rb;
	private static final Logger LOGGER = Logger.getLogger(DatabaseConnectionFactory.class.getName());
	private static final String BUNDLE_PATH = "co.mum.roommgt.dao.transaction.bundle.transaction";

	public TransactionDAO() {
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
	public List<Transaction> getTransactions() {
		System.out.println("getTransaction invoked!");
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Transaction> transList = new ArrayList<Transaction>();

		try {
			con = DatabaseConnectionFactory.createConnection();
			pst = con.prepareStatement(rb.getString("getTransactions"));
			rs = pst.executeQuery();
			// https://stackoverflow.com/questions/21956042/mapping-a-jdbc-resultset-to-an-object
			while (rs.next()) {
				Transaction sd = new Transaction();
				sd.setBuildingFrom(rs.getInt("BuildingFrom"));
				sd.setDepartment(rs.getString("Department"));
				sd.setDescription(rs.getString("Description"));
				sd.setEmail(rs.getString("Email"));
				sd.setId(rs.getInt("Id"));
				sd.setPhoneNumber(rs.getString("PhoneNumber"));
				sd.setRequest_TypeId(rs.getInt("Request_TypeId"));
				sd.setStudentid(rs.getInt("StudentId"));
				sd.setTransactionDate(rs.getString("TransactionDate"));
				transList.add(sd);
			}
			return transList;

		} catch (SQLException sqle) {
			LOGGER.fine("Error: method getTransaction method!" + sqle.getMessage());
		} finally {
			DBUtil.closePreparedStatement(pst);
			DBUtil.closeResultSet(rs);
			DBUtil.closeConnection(con);
		}
		return null;

	}

	 

	public boolean AddTransaction(Transaction trans) {
		if (trans==null)
			return false;
		
		System.out.println("AddTransaction invoked!");
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Transaction> transList = new ArrayList<Transaction>();

		try {
			con = DatabaseConnectionFactory.createConnection();
			pst = con.prepareStatement(rb.getString("insertIntoTransaction"));
			pst.setString(1, trans.getDescription());
			pst.setInt(2, trans.getStudentid());
			pst.setInt(3, trans.getRequest_TypeId());
			pst.setInt(4, 12);
			pst.setInt(5, trans.getBuildingFrom());
			pst.setString(6, trans.getTransactionDate());
			pst.setString(7, trans.getEmail());
			pst.setString(8, trans.getPhoneNumber());
			pst.setString(9, trans.getDepartment());
			pst.executeUpdate();
			// https://stackoverflow.com/questions/21956042/mapping-a-jdbc-resultset-to-an-object
		} catch (SQLException sqle) {
			LOGGER.fine("Error: method getTransaction method!" + sqle.getMessage());
		
		} finally {
			DBUtil.closePreparedStatement(pst);
			DBUtil.closeResultSet(rs);
			DBUtil.closeConnection(con);
		}
		return true;

	}

	
	public boolean UpdateTransaction(Transaction trans, int id ) {
		if (trans==null)
			return false;
		
		System.out.println("AddTransaction invoked!");
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = DatabaseConnectionFactory.createConnection();
			pst = con.prepareStatement(rb.getString("updateIntoTransactoin"));
			pst.setInt(1, trans.getId());
			pst.setString(2, trans.getDescription());
			pst.setInt(3, trans.getStudentid());
			pst.setInt(4, trans.getRequest_TypeId());
			pst.setInt(5, 12);
			pst.setInt(6, trans.getBuildingFrom());
			pst.setString(7, trans.getTransactionDate());
			pst.setString(8, trans.getEmail());
			pst.setString(9, trans.getPhoneNumber());
			pst.setString(10, trans.getDepartment());
			pst.setInt(11, id);
			rs = pst.executeQuery();
			// https://stackoverflow.com/questions/21956042/mapping-a-jdbc-resultset-to-an-object
		} catch (SQLException sqle) {
			LOGGER.fine("Error: method getTransaction method!" + sqle.getMessage());
		
		} finally {
			DBUtil.closePreparedStatement(pst);
			DBUtil.closeResultSet(rs);
			DBUtil.closeConnection(con);
		}
		return true;

	}

	
 
	
	public boolean DeleteTransaction(int id) {
		System.out.println("AddTransaction invoked!");
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Transaction> transList = new ArrayList<Transaction>();

		try {
			con = DatabaseConnectionFactory.createConnection();
			pst = con.prepareStatement(rb.getString("updateIntoTransactoin")); 
			pst.setInt(1, id);
			rs = pst.executeQuery();
			// https://stackoverflow.com/questions/21956042/mapping-a-jdbc-resultset-to-an-object
		} catch (SQLException sqle) {
			LOGGER.fine("Error: method getTransaction method!" + sqle.getMessage());
		
		} finally {
			DBUtil.closePreparedStatement(pst);
			DBUtil.closeResultSet(rs);
			DBUtil.closeConnection(con);
		}
		return true;

	}
	
	
	

}
