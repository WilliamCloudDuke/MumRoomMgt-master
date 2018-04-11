package co.mum.roommgt.controller;
/* this is me */
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.mum.roommgt.dao.login.LoginDAO;
import co.mum.roommgt.model.Account;
import co.mum.roommgt.model.ROLE_TYPE;
import co.mum.roommgt.util.DatabaseConnectionFactory;

/**
 * LoginController Description: Control the access to application Last Updated:
 * 01/19/2018
 * 
 * @version 1.0 18 March 2018
 * @author William Chaparro
 */

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(DatabaseConnectionFactory.class.getName());
	private LoginDAO loginDAO;

	public LoginController() {
		super();
		LOGGER.setLevel(Level.FINE);
		loginDAO = new LoginDAO();
	}

	/**
	 * Servlet implementation in charge of validate users and redirect to home or
	 * login JSP pages.
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
		System.out.println("LoginController---");
		String homeStudent = getServletContext().getInitParameter("homeStudent");
		String homeDirector = getServletContext().getInitParameter("homeDirector");
		String login = getServletContext().getInitParameter("login");
		String username = request.getParameter("inputEmail");
		String password = request.getParameter("inputPassword");
		System.out.println("username: " + username);
		System.out.println("password: " + password);
		if (null != username && !username.equals("") && null != password && !password.equals("")) {
			if (loginDAO.isValidUser(username, password)) {
				System.out.println("VALID USER");
				Account user = loginDAO.getAccount(username, password);
				HttpSession session = request.getSession();
				session.setAttribute("userBean", user);
				if (user.getRoleType().getRoleTypeCode() == ROLE_TYPE.STUDENT.getRoleTypeCode()) {
					System.out.println("STUDENT");
					RequestDispatcher rd = request.getRequestDispatcher(homeStudent);
					rd.forward(request, response);
				} else {
					System.out.println("DIRECTOR");
					RequestDispatcher rd = request.getRequestDispatcher(homeDirector);
					rd.forward(request, response);
				}
			} else {
				request.setAttribute("errorMessage", "Invalid username or password");
				RequestDispatcher rd = request.getRequestDispatcher(login);
				rd.forward(request, response);
			}
		} else {
			request.setAttribute("errorMessage", "Invalid username or password");
			RequestDispatcher rd = request.getRequestDispatcher(login);
			rd.forward(request, response);
			LOGGER.fine("Error: Invalid username or password!");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
