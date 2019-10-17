/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.controller;

import asd.demo.model.OpalCard;
import asd.demo.model.User;
import asd.demo.model.dao.MongoDBConnector;
import asd.demo.model.dao.OpalCardDao;
import asd.demo.model.dao.PaymentHistoryDao;
import com.mongodb.MongoClient;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
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
@WebServlet(name = "TopUpServlet", urlPatterns = {"/topup"})
public class TopUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get Database Connector
        MongoDBConnector connector = new MongoDBConnector();

        // Get Database Client
        MongoClient client = connector.openConnection();

        // Get Database DAO
        OpalCardDao db = new OpalCardDao(client);

        // Get selected opalcard ID
        String ID = request.getParameter("id");
        
        // Get the card's property by ID
        OpalCard card = db.getOpalCard(ID);

        // Get Session
        HttpSession session = request.getSession();

        // Put into session 
        session.setAttribute("opalcard", card);

        // Get view page.
        RequestDispatcher view = request.getRequestDispatcher("topup.jsp");

        // Forward user to the view page.
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Validator validator = new Validator();

        // Get Database Connector
        MongoDBConnector connector = new MongoDBConnector();

        // Get Database Client
        MongoClient client = connector.openConnection();

        // Get Database DAO
        OpalCardDao db = new OpalCardDao(client);

        // Get Database DAO
        PaymentHistoryDao db2 = new PaymentHistoryDao(client);

        // Get Session
        HttpSession session = request.getSession();
        
        // Get the entered amount
        String amount = request.getParameter("amount");
        
        // Validate amount by integer
        if (!validator.validateNumber(amount)) {
            
            // Put error into session 
            session.setAttribute("existErr2", "Amount you have entered is not valid number.");

            // Get view page.
            RequestDispatcher view = request.getRequestDispatcher("topup.jsp");

            // Forward user to the view page.
            view.forward(request, response);
        } else {

            try {

                // Get Selected OpalCardId
                String ID = request.getParameter("id");
                
                // Get the card's property by ID
                OpalCard card = db.getOpalCard(ID);
                
                // Convert the amount to double
                double amount2 = Double.parseDouble(amount);
                
                // Add card balance by entered amount
                card.addBalance(amount2);
                
                // Update card in the database
                db.updateCard(card);
                
                // Get current date
                Date date = new Date();
                long time = date.getTime();
                Timestamp isTime = new Timestamp(time);
                String timeStamp = "" + isTime;

                // Get User
                User user = (User) session.getAttribute("user");

                // Add History after Top Up
                db2.addHistory(ID, amount2, timeStamp, user.getEmail());
                
                // Bring user to opalcardlist.jsp
                response.sendRedirect("ListOpalCard");
            } catch (Exception ex) {
                
            }
        }
        }
}
