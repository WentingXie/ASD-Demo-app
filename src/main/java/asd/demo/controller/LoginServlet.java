package asd.demo.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import asd.demo.model.User;
import asd.demo.service.IOrderService;
import asd.demo.service.IUserService;
import asd.demo.service.impl.OrderServiceImpl;
import asd.demo.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		IUserService service = new UserServiceImpl();

		User u = service.loginUser(email, password);
		if (u == null) {
			System.out.println("no user");
			request.setAttribute("message", "User does not exist or Password input error");
			request.getRequestDispatcher("/message.jsp").forward(request, response);

			return;
		}
		// login success
		request.getSession().setAttribute("user", u);
		request.getRequestDispatcher("/goMain").forward(request, response);
	}

	private void goMain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User loginUser = (User) request.getSession().getAttribute("user");

		if (loginUser != null) {

			IOrderService orderService = new OrderServiceImpl();
			List<String> opalCardTypes = new ArrayList<String>();
			opalCardTypes = orderService.getOrdersTypesByUserId(loginUser.getUserId());

			request.getSession().setAttribute("opalCardTypes", opalCardTypes);
			request.getRequestDispatcher("/main.jsp").forward(request, response);

		} else {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
}
