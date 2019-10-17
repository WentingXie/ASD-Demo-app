package asd.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Date;

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
import java.sql.Timestamp;

/**
 * Servlet implementation class CardServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderServlet() {
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
        // Create a new order
	private synchronized void createOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                 
		String opalCardSequenceNumber = request.getParameter("opalCardSequenceNumber");
		String productTypeId = request.getParameter("productTypeId");
		String userAddress = request.getParameter("userAddress");
		String postalCode = request.getParameter("postalCode");
		User loginUser = (User) request.getSession().getAttribute("user");
                
        Date date = new Date();
		long time = date.getTime();
		Timestamp isTime = new Timestamp(time);
		String timeStamp = "" + date;
		//Create new order
		Order order = new Order();
                // Setup details of order
		order.setUserId(loginUser.getUserId());
		order.setProductTypeId(productTypeId);
		order.setOpalCardSequenceNumber(opalCardSequenceNumber);
		order.setOrderDate(timeStamp);
		order.setUserAddress(userAddress);
		order.setPostalCode(postalCode);

		PrintWriter printWriter = response.getWriter();
		JSONObject json = new JSONObject();

		IOpalCardService opalCardService = new OpalCardServiceImpl();
                //Get opal card
		OpalCard oc = opalCardService.checkOneOpalCardBySequenceNumber(opalCardSequenceNumber);
                // if status is 0, then order opal card
		if ("0".equals(oc.getStatus())) {

			if (opalCardService.updateOpalStatus(oc) > 0) {
				IOrderService orderService = new OrderServiceImpl();
				int rs = orderService.createOrder(order);
				if (rs == 0) {
					json.append("msg", "Order an Opal Card failed.");
				}
			} else {
				json.append("msg", "Order an Opal Card failed.");
			}

		} else {
			json.append("msg", "The opalCard has been saled,please choose another one...");
		}

		// success
		printWriter.print(json.toString());
		printWriter.flush();
		printWriter.close();
	}

	private void chooseOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productTypeId = request.getParameter("productTypeId");

		System.out.println(productTypeId);
		IOpalCardService opalCardService = new OpalCardServiceImpl();
                //Get opal card
		OpalCard oc = opalCardService.getOneOpalCardByProducTypeId(productTypeId);

		System.out.println(oc == null ? oc : oc.toString());

		JSONObject json = new JSONObject();
		PrintWriter printWriter = response.getWriter();
                //if opal card is null, then get the notification
		if (oc == null) {
			json.put("msg", "Insufficient stock, please choose another card.");
		} else {
			request.getSession().setAttribute("oc", oc);
			json.put("msg", "ok");
		}
		printWriter.print(json.toString());
		printWriter.flush();
		printWriter.close();

	}

}