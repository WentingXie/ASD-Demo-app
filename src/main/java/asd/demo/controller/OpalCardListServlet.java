package asd.demo.controller;

import asd.demo.model.dao.OpalCardDao;
import asd.demo.model.OpalCard;
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
@WebServlet(name = "OpalCardListServlet", urlPatterns = {"/ListOpalCard"})
public class OpalCardListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get Database Connector
        MongoDBConnector connector = new MongoDBConnector();

        // Get Database Client
        MongoClient client = connector.openConnection();

        // Get Database DAO
        OpalCardDao db = new OpalCardDao(client);

        // Get Session
        HttpSession session = request.getSession();

        // Get User Session
        User user = (User) session.getAttribute("user");

        // Get opalcardlist from current logged in user
        List<OpalCard> opallist = db.listOpalCard(user.getEmail());

        // Put into session 
        session.setAttribute("opallist", opallist);

        // Get view page.
        RequestDispatcher view = request.getRequestDispatcher("opalcardlist.jsp");

        // Forward user to the view page.
        view.forward(request, response);
    }
}
