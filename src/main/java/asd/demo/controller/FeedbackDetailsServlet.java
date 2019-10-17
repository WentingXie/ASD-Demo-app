/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.controller;

import asd.demo.model.Feedback;
import asd.demo.model.User;
import asd.demo.model.dao.FeedbackDao;
import asd.demo.model.dao.MongoDBConnector;
import asd.demo.model.dao.UserDao;
import asd.demo.service.IUserService;
import asd.demo.service.impl.UserServiceImpl;
import asd.demo.utils.Email;
import com.mongodb.MongoClient;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pancham singh
 */
@WebServlet(name = "FeedbackDetails", urlPatterns = {"/FeedbackDetailsServlet"})
public class FeedbackDetailsServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             // Get Database Connector
        MongoDBConnector connector = new MongoDBConnector();

        // Get Database Client
        MongoClient client = connector.openConnection();

        // Get Database DAO
        FeedbackDao db = new FeedbackDao(client);

        // Get Session
        HttpSession session = request.getSession();
        
        // Get User
        String email = request.getParameter("feedbackUserEmail");
                System.out.println(email);

        Feedback feedback = db.getFeedback(email);
        
       // Get Opal Card List
       // List<OpalCard> opallist = db.listOpalCard();
        
        // Put into session 
        session.setAttribute("feedBackDetails", feedback);
        // Get view page.
        RequestDispatcher view = request.getRequestDispatcher("/feedbackDetails.jsp");
        
        // Forward user to the view page.
        view.forward(request, response);
    }
 
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String body = request.getParameter("body");
		String email = request.getParameter("email");
                                                    new Email(email,body);
                                                    response.getWriter().print("<script>alert('YOUR QUIERY HAS BEEN SUCCESFULLY FORWARDED TO THE OUR STAFF, YOU WILL BE CONTACTED BACK SHORTLY THROUGH THE EMAIL PROVIDED.')</script>");
              doGet(request, response);
 }

                

}
