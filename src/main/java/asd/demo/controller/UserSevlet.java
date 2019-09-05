package asd.demo.controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import asd.demo.model.User;
import asd.demo.service.IUserService;
import asd.demo.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserSevlet
 */
@WebServlet("/UserSevlet")
public class UserSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserSevlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
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

	private void changeInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("changeInfo...");
		String username = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");

		IUserService service = new UserServiceImpl();

		User user = new User();
		user.setName(username);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhone(phone);
		System.out.println(user.toString());
		int u = service.updateUserInfo(user);
		if (u == 0) {
			request.setAttribute("message", "Update Information Failed.");
			request.getRequestDispatcher("/edit_user.jsp").forward(request, response);
			return;
		}
		// register success
		user = service.getUser(user.getEmail());
		response.getWriter().print("<script>alert('Update Information Success!');window.location='main.jsp'</script>");
		request.getSession().setAttribute("user", user);

	}

}
