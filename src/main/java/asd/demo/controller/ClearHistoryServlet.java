package asd.demo.controller;

import asd.demo.model.dao.MongoDBConnector;
import asd.demo.model.dao.PaymentHistoryDao;
import com.mongodb.MongoClient;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "clearHistory", urlPatterns = {"/clearHistory"})
public class ClearHistoryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get Database Connector
        MongoDBConnector connector = new MongoDBConnector();

        // Get Database Client
        MongoClient client = connector.openConnection();

        // Get Database DAO
        PaymentHistoryDao db = new PaymentHistoryDao(client);
        
        // Delete All Payment History
        db.deleteAll();
        
        // Bring the user to paymenthistorylist.jsp
        response.sendRedirect("ListPaymentHistory");
    }
}
