/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.controller;

import asd.demo.model.dao.OpalCardDao;


import asd.demo.model.OpalCard;
import asd.demo.model.User;
import asd.demo.model.dao.MongoDBConnector;
import com.mongodb.MongoClient;
import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "OpalCardServlet", urlPatterns = {"/listOpalCard"})
public class OpalCardServlet extends HttpServlet {

  

    
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
        
        // Get User
        //User user = (User)session.getAttribute("user");
        
        //List<OpalCard> opallist = db.listOpalCard(user.getId());
        
       // Get Opal Card List
        List<OpalCard> opallist = db.listOpalCard();
        
        
        
        // Put into session 
        session.setAttribute("opallist", opallist);
        
        // Get view page.
        RequestDispatcher view = request.getRequestDispatcher("opalcardlist.jsp");
        
        // Forward user to the view page.
        view.forward(request, response);
        
        
        //session.setAttribute("logList",logList);
//        try {
//            User user = (User) session.getAttribute("user");
//            String userID = user.getID();
//            
//            DatabaseManager manager = (DatabaseManager)session.getAttribute("manager");
//            logList = manager.searchLog(userID);
//            
//            session.setAttribute("logList",logList);
//             RequestDispatcher view = request.getRequestDispatcher("/UserAccessManagement/myAccessLogs.jsp");
//        view.forward(request, response);
//        } catch (SQLException ex) {
//            Logger.getLogger(listAccessLogs.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
        
     
    


    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}