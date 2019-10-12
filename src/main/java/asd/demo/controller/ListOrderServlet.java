/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.controller;

import asd.demo.model.dao.PaymentHistoryDao;
import asd.demo.model.Order;
import asd.demo.model.User;
import asd.demo.model.dao.MongoDBConnector;
import asd.demo.model.dao.OrderDao;
import com.mongodb.MongoClient;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jonny
 */
@WebServlet("/ListOrderServlet")
public class ListOrderServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get Database Connector
		MongoDBConnector connector = new MongoDBConnector();

		// Get Database Client
		MongoClient client = connector.openConnection();

		// Get Database DAO
		OrderDao db = new OrderDao(client);

		// Get Session
		HttpSession session = request.getSession();

		// Get User
		User user = (User) session.getAttribute("user");

		List<Order> Order = db.listOrder(user.getUserId());

		// Put into session
		session.setAttribute("orderlist", Order);

		// Get view page.
		request.getRequestDispatcher("/OrderHistory.jsp").forward(request, response);

	
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
