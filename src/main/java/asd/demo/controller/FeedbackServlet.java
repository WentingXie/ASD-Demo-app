package asd.demo.controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import asd.demo.model.Feedback;
import asd.demo.model.OpalCard;
import asd.demo.model.User;
import asd.demo.model.dao.FeedbackDao;
import asd.demo.model.dao.MongoDBConnector;
import asd.demo.model.dao.OpalCardDao;
import asd.demo.service.IFeedbackService;
import asd.demo.service.IUserService;
import asd.demo.service.impl.FeedbackServiceImpl;
import asd.demo.service.impl.UserServiceImpl;
import com.mongodb.MongoClient;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserSevlet
 */
@WebServlet("/FeedbackServlet")
public class FeedbackServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        System.out.println("changeInfo...");
        String opalCardNo = request.getParameter("opalCardNo");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String street1 = request.getParameter("street1");
        String street2 = request.getParameter("street2");
        String city = request.getParameter("city");
        String pinCode = request.getParameter("pinCode");
        String state = request.getParameter("state");
        String country = request.getParameter("country");
        String email = request.getParameter("email");
        String enqueryType = request.getParameter("enqueryType");
        String enquery = request.getParameter("enquery");

        IFeedbackService service = new FeedbackServiceImpl();
        Feedback feedback = new Feedback();
        feedback.setOpalCardNo(opalCardNo);
        feedback.setFirstName(firstName);
        feedback.setLastName(lastName);
        feedback.setAddress(address);
        feedback.setStreet1(street1);
        feedback.setStreet2(street2);
        feedback.setCity(city);
        feedback.setState(state);
        feedback.setCountry(country);
        feedback.setEnquery(enquery);
        feedback.setEnqueryType(enqueryType);
        feedback.setEmail(email);
        System.out.println(feedback.toString());
        int u = service.insertFeedback(feedback);
        if (u == 0) {
            request.setAttribute("message", "Add Information Failed.");
            request.getRequestDispatcher("/feedback.jsp").forward(request, response);
            return;
        }
        // register success
        response.getWriter().print("<script>alert('Update Information Success!');window.location='main.jsp'</script>");
//		doGet(request, response);
    }

}
