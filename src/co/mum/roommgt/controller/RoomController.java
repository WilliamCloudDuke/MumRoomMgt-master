package co.mum.roommgt.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import co.mum.roommgt.dao.room.RoomDAO;
import co.mum.roommgt.model.Account;
import co.mum.roommgt.model.Room;
import co.mum.roommgt.util.DatabaseConnectionFactory;

/**
 * RoomController Description: Controls the logic for Rooms Lists, Change Rooms
 * and Assign Room logic 01/20/2018
 * 
 * @version 1.0 18 March 2018
 * @author William Chaparro
 */

public class RoomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(DatabaseConnectionFactory.class.getName());
	private RoomDAO dao;

	public RoomController() {
		super();
		LOGGER.setLevel(Level.FINE);
		dao = new RoomDAO();
	}

	/**
	 * Servlet implementation in charge of Room logic, insert, update and delete
	 * data
	 * 
	 * @param arg
	 *            request object and response object.
	 * @exception ServletException
	 *                and IOException
	 * @return No return value.
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("RoomController---");
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		List<Room> roomsByDirectorList = new ArrayList<>();
		String jsonOutput = "";
		HttpSession session = request.getSession();
		Account user = (Account) session.getAttribute("userBean");
		if (null != user && null != user.getUserName() && !user.getUserName().equals("")) {
			System.out.println("username: " + user.getUserName());
			roomsByDirectorList = dao.getRoomsByDirector(user.getBuildingNumber());
			jsonOutput = gson.toJson(roomsByDirectorList);
			out.println(jsonOutput);
			out.flush();
			out.close();
		} else {
			System.out.println("Error : userBean from session is NULL");
			out.close();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("actionRoom");
		System.out.println("action: " + action);
		PrintWriter out = response.getWriter();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		StringBuilder buffer = new StringBuilder();

		if (null != action && !action.equals("")) {
			BufferedReader reader = request.getReader();
			String line;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			String data = buffer.toString();
			System.out.println("data: " + data);
			try {
				Room room = gson.fromJson(data, Room.class);
			} catch (IllegalStateException | JsonSyntaxException e) {
				e.printStackTrace();
			}
			switch (action) {
			case "edit":
				System.out.println("EDIT - Call RoomDAO.updateRoom ");
				break;
			case "delete":
				System.out.println("DELETE - Call RoomDAO.deleteRoom ");
				break;
			case "new":
				System.out.println("NEW - Call RoomDAO.newRoom ");
				break;
			}
		}
	}
}
