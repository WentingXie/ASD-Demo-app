package asd.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import asd.demo.model.OpalCard;
import asd.demo.model.Order;
import asd.demo.model.User;
import asd.demo.service.IOpalCardService;
import asd.demo.service.IOrderService;
import asd.demo.service.impl.OpalCardServiceImpl;
import asd.demo.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class OpalCardServlet
 */
@WebServlet("/OpalCardServlet")
public class OpalCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OpalCardServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI();
		String methodName = url.substring(url.lastIndexOf("/") + 1);
		Method method = null;
		System.out.println(methodName);
		try {
			method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (Exception e) {
			throw new RuntimeException("Error calling method...");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
        // Activation function
	private void activateCard(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sequenceNumber = request.getParameter("sequenceNumber");
		String securityNumber = request.getParameter("securityNumber");
		System.out.println("sequenceNumber" + sequenceNumber);
		System.out.println("securityNumber" + securityNumber);
		JSONObject json = new JSONObject();
		PrintWriter printWriter = response.getWriter();
                //Validation for null 
		if (sequenceNumber == null || sequenceNumber.isEmpty()) {
			json.put("msg", "Plesase enter the SequenceNumber.");

		} else if (securityNumber == null || securityNumber.isEmpty()) {
			json.put("msg", "Plesase enter the SecurityNumber.");
		} else {
                        // Get current login user
			User loginUser = (User) request.getSession().getAttribute("user");

			IOrderService orderService = new OrderServiceImpl();
                           //Get order by user and opal card number and status
			List<Order> orderList = orderService.getOrdersByUserIdAndSequenceNumberAndStatus(loginUser.getUserId(),
					sequenceNumber, "0"); // query unbound order
                        //if order list is not null
			if (orderList.size() > 0) {

				IOpalCardService opalCardService = new OpalCardServiceImpl();
                                //Get Existing opal card
				OpalCard oc = opalCardService.getOneOpalCardBySequenceAndSecurityNumber(sequenceNumber, securityNumber);
				System.out.println(oc == null ? oc : oc.toString());
				if (oc != null) {
					orderService.updateOrderStatus(orderList.get(0));// update order status
				} else {
					json.put("msg",
							"No Opal Card does exists or SequenceNumberhas been used,Please enter the correct SequenceNumber or SecurityNumber .");
				}
			} else {
				json.put("msg",
						"No Opal Card does exists or SequenceNumber has been used,Please enter the correct SequenceNumber or SecurityNumber.");
			}
		}
		printWriter.print(json.toString());
		printWriter.flush();
		printWriter.close();
	}

	/**
	 * just for test
	 */
	private void initCards(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IOpalCardService opalCardService = new OpalCardServiceImpl();
		String rs = opalCardService.initAllOpalCardsStatus();
		System.out.println(rs);
	}

}
