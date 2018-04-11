package co.mum.roommgt.dao.student;

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
import co.mum.roommgt.util.DBUtil;
import co.mum.roommgt.util.DatabaseConnectionFactory;

public class StudentDAO {

	private ResourceBundle rb;
	private static final Logger LOGGER = Logger.getLogger(DatabaseConnectionFactory.class.getName());
	private static final String BUNDLE_PATH = "co.mum.roommgt.dao.student.bundle.student";

	public StudentDAO() {
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
	public List<Student> getStudents() {
		System.out.println("getStudents() invoked!");
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Student> studList = new ArrayList<Student>();

		try {
			con = DatabaseConnectionFactory.createConnection();
			pst = con.prepareStatement(rb.getString("getStudents"));
			rs = pst.executeQuery();
			// https://stackoverflow.com/questions/21956042/mapping-a-jdbc-resultset-to-an-object
			while (rs.next()) {
				Student sd = new Student();
				sd.setId(rs.getInt("Id"));
				sd.setName(rs.getString("Name"));
				sd.setLastName(rs.getString("LastName"));
				sd.setEmail(rs.getString("Email"));
				sd.setPhone(rs.getString("Phone"));
				sd.setSex(rs.getString("Sex"));
				sd.setNationality(rs.getString("Nationality"));
				sd.setRoleTypeId(rs.getInt("Role_Typeid"));
				sd.setAccountId(rs.getInt("AccountId"));
				studList.add(sd);
			}
			return studList;

		} catch (SQLException sqle) {
			LOGGER.fine("Error: method getStudents method!" + sqle.getMessage());
		} finally {
			DBUtil.closePreparedStatement(pst);
			DBUtil.closeResultSet(rs);
			DBUtil.closeConnection(con);
		}
		return null;

	}

	public Student getStudentById(String _acctId) {
		System.out.println("getStudentsById() invoked!");
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Student sd = new Student();

		try {
			con = DatabaseConnectionFactory.createConnection();
			pst = con.prepareStatement(rb.getString("getStudentById"));
			pst.setString(1, _acctId);
			rs = pst.executeQuery();

			// https://stackoverflow.com/questions/21956042/mapping-a-jdbc-resultset-to-an-object
			if (rs.next()) {
				sd.setId(rs.getInt("Id"));
				sd.setName(rs.getString("Name"));
				sd.setLastName(rs.getString("LastName"));
				sd.setEmail(rs.getString("Email"));
				sd.setPhone(rs.getString("Phone"));
				sd.setSex(rs.getString("Sex"));
				sd.setNationality(rs.getString("Nationality"));
				sd.setRoleTypeId(rs.getInt("Role_Typeid"));
				sd.setAccountId(rs.getInt("AccountId"));
			}

		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
			LOGGER.fine("Error: method getStudentsById method!" + sqle.getMessage());
		} finally {
			DBUtil.closePreparedStatement(pst);
			DBUtil.closeResultSet(rs);
			DBUtil.closeConnection(con);
		}
		return sd;

	}

	public boolean isUserAnAdmin(String username) {

		System.out.println("getStudentsByUserName  invoked!");
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Student sd = new Student();

		try {
			con = DatabaseConnectionFactory.createConnection();
			pst = con.prepareStatement(rb.getString("getStudentByUserName"));
			pst.setString(1, username);
			rs = pst.executeQuery();

			// https://stackoverflow.com/questions/21956042/mapping-a-jdbc-resultset-to-an-object
			if (rs.next()) {

				if (rs.getInt("Role_Typeid") == 1 || rs.getInt("Role_Typeid") == 2) {
					return true;
				}

			}

		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
			LOGGER.fine("Error: method getStudentsByUserName method!" + sqle.getMessage());
		} finally {
			DBUtil.closePreparedStatement(pst);
			DBUtil.closeResultSet(rs);
			DBUtil.closeConnection(con);
		}

		return false;

	}

	public Student getStudentsByUserName(String username) {
		System.out.println("getStudentsByUserName  invoked!");
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Student sd = new Student();

		try {
			con = DatabaseConnectionFactory.createConnection();
			pst = con.prepareStatement(rb.getString("getStudentByUserName"));
			pst.setString(1, username);
			rs = pst.executeQuery();

			// https://stackoverflow.com/questions/21956042/mapping-a-jdbc-resultset-to-an-object
			if (rs.next()) {
				sd.setId(rs.getInt("Id"));
				sd.setName(rs.getString("Name"));
				sd.setLastName(rs.getString("LastName"));
				sd.setEmail(rs.getString("Email"));
				sd.setPhone(rs.getString("Phone"));
				sd.setSex(rs.getString("Sex"));
				sd.setNationality(rs.getString("Nationality"));
				sd.setRoleTypeId(rs.getInt("Role_Typeid"));
				sd.setAccountId(rs.getInt("AccountId"));
				return sd;
			}

		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
			LOGGER.fine("Error: method getStudentsByUserName method!" + sqle.getMessage());
		} finally {
			DBUtil.closePreparedStatement(pst);
			DBUtil.closeResultSet(rs);
			DBUtil.closeConnection(con);
		}

		return null;

	}

}
