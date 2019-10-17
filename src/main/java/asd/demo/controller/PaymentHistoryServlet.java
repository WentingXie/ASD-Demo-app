/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.controller;

import asd.demo.model.dao.PaymentHistoryDao;
import asd.demo.model.PaymentHistory;
import asd.demo.model.User;
import asd.demo.model.dao.MongoDBConnector;
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
@WebServlet(name = "PaymentHistoryServlet", urlPatterns = {"/ListPaymentHistory"})
public class PaymentHistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get Database Connector
        MongoDBConnector connector = new MongoDBConnector();

        // Get Database Client
        MongoClient client = connector.openConnection();

        // Get Database DAO
        PaymentHistoryDao db = new PaymentHistoryDao(client);

        // Get Session
        HttpSession session = request.getSession();

        // Get User
        User user = (User) session.getAttribute("user");
        
        // Get User' search 
        String search = request.getParameter("searchbox");
        
        try {
        
        // Get paymenthistorylist by user's email and search    
        List<PaymentHistory> historylist = db.listPaymentHistoryByNumber(user.getEmail(), search);
        
        // Put into Session
        session.setAttribute("historylist", historylist);
        
        } catch (Exception ex) {
            
        }

        // Get view page.
        RequestDispatcher view = request.getRequestDispatcher("paymenthistorylist.jsp");

        // Forward user to the view page.
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get Validator
        Validator validator = new Validator();
        
        // Get Database Connector
        MongoDBConnector connector = new MongoDBConnector();

        // Get Database Client
        MongoClient client = connector.openConnection();

        // Get Database DAO
        PaymentHistoryDao db = new PaymentHistoryDao(client);

        // Get Session
        HttpSession session = request.getSession();

        // Get User
        User user = (User) session.getAttribute("user");
        
        // Get User' search 
        String search = request.getParameter("searchbox");
        
        // Validate search by integer
        if (!validator.validateNumber(search)){
        
        // Put error into session    
        session.setAttribute("existErr", "Card Number you have entered is not valid number.");
        
        // Get view page
        RequestDispatcher view = request.getRequestDispatcher("paymenthistorylist.jsp");

        // Forward user to the view page.
        view.forward(request, response);
        } else {
            
        try {
        
        // Get paymenthistorylist by user's email and search      
        List<PaymentHistory> historylist = db.listPaymentHistoryByNumber(user.getEmail(), search);
        
        // Put into Session
        session.setAttribute("historylist", historylist);
        
        // Clear error attribute
        session.setAttribute("existErr", "");
        
        // Get view page
        RequestDispatcher view = request.getRequestDispatcher("paymenthistorylist.jsp");

        // Forward user to the view page.
        view.forward(request, response);
        
        } catch (Exception ex) {
            
        }
        }
    }
}
