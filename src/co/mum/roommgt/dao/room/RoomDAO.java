/**
 * 
 */
package co.mum.roommgt.dao.room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import co.mum.roommgt.model.Room;
import co.mum.roommgt.util.DBUtil;
import co.mum.roommgt.util.DatabaseConnectionFactory;

/**
 * LoginDAO Description: 01/19/2018
 * 
 * @version 1.0 18 March 2018
 * @author William Chaparro
 */
public class RoomDAO {

	private ResourceBundle rb;
	private static final Logger LOGGER = Logger.getLogger(DatabaseConnectionFactory.class.getName());
	private static final String BUNDLE_PATH = "co.mum.roommgt.dao.room.bundle.room";

	public RoomDAO() {
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
	 * @return Collection of Rooms objects
	 */
	public List<Room> getRoomsByDirector(int buildingNumber) {
		System.out.println("***getRoomsByDirector - buildingNumber***" + buildingNumber);
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Room> roomList = new ArrayList<>();
		try {
			con = DatabaseConnectionFactory.createConnection();
			pst = con.prepareStatement(rb.getString("getRoomsByDirector"));
			pst.setInt(1, buildingNumber);
			rs = pst.executeQuery();
			while (rs.next()) {
				Room room = new Room();
				room.setId(rs.getInt("Id"));
				room.setStatus(rs.getString("Status"));
				room.setFrame(rs.getString("Frame"));
				room.setMattress(rs.getString("Mattress"));
				room.setDesk(rs.getString("Desk"));
				room.setChair(rs.getString("Chair"));
				room.setBookshelf(rs.getString("Bookshelf"));
				room.setDresser(rs.getString("Dresser"));
				room.setWasteBasket(rs.getString("Wastebasket"));
				room.setRecycleBin(rs.getString("Recycle_bin"));
				room.setArrivalId(rs.getInt("ArrivalId"));
				room.setDepartureId(rs.getInt("DepartureId"));
				room.setRoom_number(rs.getString("room_number"));
				room.setBuilding_number(rs.getString("building_number"));
				room.setLast_Updated_By(rs.getString("Last_Updated_By"));
				room.setNotes(rs.getString("notes"));
				room.setStudentName(rs.getString("name"));
				room.setStudentLastName(rs.getString("LastName"));
				roomList.add(room);
			}
		} catch (SQLException sqle) {
			LOGGER.fine("Error: method getRoomsByDirector method!" + sqle.getMessage());
		} finally {
			DBUtil.closePreparedStatement(pst);
			DBUtil.closeResultSet(rs);
			DBUtil.closeConnection(con);
		}
		return roomList;
	}

	/**
	 * 
	 * @param Room
	 *            room object updated, building number, room number
	 * @return boolean expression
	 */
	public boolean updateRoom(Room roomUpdated, int buildingNumber, int roomNumber) {
		System.out.println(
				"***updateRoom - buildingNumber***" + buildingNumber + " roomNumber: " + roomUpdated.getRoom_number());
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = DatabaseConnectionFactory.createConnection();
			pst = con.prepareStatement(rb.getString("updateRoom"));
			pst.setString(1, roomUpdated.getRoom_number());
			pst.setString(2, roomUpdated.getStatus());
			pst.setString(3, roomUpdated.getFrame());
			pst.setString(4, roomUpdated.getMattress());
			pst.setString(5, roomUpdated.getDesk());
			pst.setString(6, roomUpdated.getChair());
			pst.setString(7, roomUpdated.getBookshelf());
			pst.setString(8, roomUpdated.getDresser());
			pst.setString(9, roomUpdated.getWasteBasket());
			pst.setString(10, roomUpdated.getRecycleBin());
			pst.setString(11, roomUpdated.getNotes());
			pst.setInt(12, buildingNumber);
			pst.setInt(13, roomNumber);
			pst.executeUpdate();
			con.commit();
		} catch (SQLException sqle) {
			try {
				con.rollback();
			} catch (SQLException s) {
				LOGGER.fine("Error: Executing Rollback- updateRoom!" + sqle.getMessage());
				return false;
			}
			LOGGER.fine("Error: method updateRoom method!" + sqle.getMessage());
			return false;
		} finally {
			DBUtil.closePreparedStatement(pst);
			DBUtil.closeConnection(con);
		}
		return true;
	}

	/**
	 * 
	 * @param Room
	 *            room object deleted, building number, room number
	 * @return boolean expression
	 */
	public boolean deleteRoom(int buildingNumber, int roomNumber) {
		System.out.println("***deleteRoom - buildingNumber***" + buildingNumber + " roomNumber: " + roomNumber);
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = DatabaseConnectionFactory.createConnection();
			pst = con.prepareStatement(rb.getString("deleteRoom"));
			pst.setInt(1, buildingNumber);
			pst.setInt(2, roomNumber);
			pst.executeUpdate();
			con.commit();
		} catch (SQLException sqle) {
			try {
				con.rollback();
			} catch (SQLException s) {
				LOGGER.fine("Error: Executing Rollback-updateRoom!" + sqle.getMessage());
				return false;
			}
			LOGGER.fine("Error: method deleteRoom method!" + sqle.getMessage());
			return false;
		} finally {
			DBUtil.closePreparedStatement(pst);
			DBUtil.closeConnection(con);
		}
		return true;
	}
	
}
