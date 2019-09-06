package asd.demo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import asd.demo.model.User;
import asd.demo.service.IUserService;
import asd.demo.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("RegisterServerlet。。。");

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
		int u = service.registUser(user);
		if (u == 0) {
			request.setAttribute("message", "regist failed.");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		// register success
		response.getWriter()
				.print("<script>alert('Successful account registration!');window.location='main.jsp'</script>");
		request.getSession().setAttribute("user", user);
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

}
