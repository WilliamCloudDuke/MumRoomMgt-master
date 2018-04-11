package co.mum.roommgt.controller;

/**
 * LoginController Description: Control the access to application Last Updated:
 * 01/19/2018
 * 
 * @version 1.0 18 March 2018
 * @author Joseph Kelly Tusoy
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.mum.roommgt.dao.transaction.TransactionDAO;
import co.mum.roommgt.model.Transaction;

public class TransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TransactionController() {
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
		TransactionDAO tdao = new TransactionDAO();

		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonOutput = gson.toJson(tdao.getTransactions());

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
		// https://stackoverflow.com/questions/3831680/httpservletrequest-get-json-post-data

		TransactionDAO tdao = new TransactionDAO();
		String actionType = request.getParameter("actionType");
		Transaction obj = null;
		int id;
		StringBuilder buffer = new StringBuilder();
	    BufferedReader reader = request.getReader();
	    String line;
	    while ((line = reader.readLine()) != null) {
	        buffer.append(line);
	    }
	    String data = buffer.toString();
		
		try {
			if (data.length() > 0) {
			    obj = new Gson().fromJson(data, Transaction.class);
			}

			if (actionType.isEmpty() || actionType == null) {
				doGet(request, response);
			} else if (actionType.equals("new")) {
				tdao.AddTransaction(obj);
			} else if (actionType.equals("edit")) {
				if (request.getParameter("id") != null) {
					id = Integer.parseInt(request.getParameter("id"));
					tdao.AddTransaction(obj);
				}
			} else if (actionType.equals("delete")) {
				if (request.getParameter("id") != null) {
					id = Integer.parseInt(request.getParameter("id"));
					tdao.AddTransaction(obj);
				}

			} else {
				doGet(request, response);
			}

			response.setContentType("text/json");
			response.setCharacterEncoding("UTF-8");

			PrintWriter out = response.getWriter();
			// out.println(obj.getUsername());
			out.flush();
			out.close();

		} catch (Exception e) {
			System.out.println("Error parsing JSON request strin" + e.getMessage());
			throw new IOException("Error parsing JSON request string");
		}

	}

}
