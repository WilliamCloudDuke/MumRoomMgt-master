package co.mum.roommgt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.mum.roommgt.dao.report.ReportDAO;
import co.mum.roommgt.model.FacilityStatus;
import co.mum.roommgt.model.RoomStatus;

/**
 * LoginController Description: Control the access to application Last Updated:
 * 01/19/2018
 * 
 * @version 1.0 18 March 2018
 * @author Joseph Kelly Tusoy
 */

public class ReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReportController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		
		String type = request.getParameter("type");

		PrintWriter out = response.getWriter();
		ReportDAO rdao = new ReportDAO();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		List<RoomStatus> rstatList = new ArrayList<RoomStatus>();
		String jsonOutput;
		

		if (type.equals("1"))
		{
			List<RoomStatus> roomstatus = new ArrayList<RoomStatus>();
			roomstatus = rdao.reportRoomStatus();
			jsonOutput = gson.toJson(roomstatus);
		}
		else
		{
			List<FacilityStatus> facilist = new ArrayList<FacilityStatus>();
			facilist = rdao.reportFacilityStatus();
			jsonOutput = gson.toJson(facilist);
		}
 
		out.println(jsonOutput);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 
		 


		 doGet(request,response);
	}

}
