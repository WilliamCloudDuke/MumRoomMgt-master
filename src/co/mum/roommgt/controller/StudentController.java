package co.mum.roommgt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.mum.roommgt.dao.student.StudentDAO;
import co.mum.roommgt.model.Account;
import co.mum.roommgt.model.Student;

/**
 * StudentController Description: Controller for student Last Updated:
 * 01/19/2018
 * 
 * @version 1.0 18 March 2018
 * @author Joseph Kelly Tusoy
 */

public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentController() {
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

		PrintWriter out = response.getWriter();
		StudentDAO sdao = new StudentDAO();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		List<Student> studentList = new ArrayList<Student>();

		HttpSession session = request.getSession();
		Account user = (Account) session.getAttribute("userBean");

		Student stdio = sdao.getStudentsByUserName(user.getUserName());
		String listAll = request.getParameter("listAll");

		String jsonOutput = "";

		// decided to use gson instead of jackson, gson is much lighter
		if (stdio == null) {
			studentList = sdao.getStudents();
			jsonOutput = gson.toJson(studentList);
		} else if (listAll == null) {
			jsonOutput = gson.toJson(stdio);
		} else {
			studentList = sdao.getStudents();
			jsonOutput = gson.toJson(studentList);
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

		PrintWriter out = response.getWriter();
		StudentDAO sdao = new StudentDAO();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		List<Student> studentList = new ArrayList<Student>();

		String jsonOutput = "";

		studentList = sdao.getStudents();
		jsonOutput = gson.toJson(studentList);

		out.println(jsonOutput);
		out.flush();
		out.close();

	}

}
