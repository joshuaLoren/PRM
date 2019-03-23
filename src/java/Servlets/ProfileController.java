/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Data.ItemDB;
import Data.UserDB;
import Models.Item;
import Models.User;
import Models.UserItem;
import Models.UserProfile;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author small
 */
public class ProfileController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(false);
        boolean loggedIn = true;
        session.setAttribute("loggedIn", loggedIn);

        /*
            CHECK TO SEE IF THERE IS A USER
         */
        if (session.getAttribute("theUser") == null) {
            User user = UserDB.getFirstItem();
            session.setAttribute("theUser", user);

            UserProfile userProfile = new UserProfile();
            //userProfile.setUser(user);
            //a few test items are loaded via UserProfile's .getItems() method
            if (userProfile.userItems.isEmpty()) {
                //userProfile.userItems = userProfile.getItems();
            }
            session.setAttribute("userProfile", userProfile);

            /*
            AFTER THIS STEP

            1. THERE IS A USER OBJECT IN THE SESSION
            2. THAT USER OBJECT WAS USED TO CREATE A USER PROFILE
            3. USER PROFILE HAS AN ARRAY LIST OF USER ITEMS WHICH WE KNOW HAVE ACCESS TO.
             */
        }

        /*
            CONTROL FLOW WILL EITHER BYPASS THE ABOVE STATEMENT OR CONTINUE FROM
            THE ABOVE IF STATEMENT
         */
        if (session != null) {
            String action = request.getParameter("action");

            /*
                IF THERE IS NO QUERY STRING FOR THE ACTION PARAM GO TO MYITEMS.JSP

                NOTE: check if action is null first to avoid nullpointererror!! :(
             */
            if (action == null || action.equals("")) {
                getServletContext()
                        .getRequestDispatcher("/myitems.jsp")
                        .forward(request, response);
            } else {
                /*
                    IF ACTION VALUE IS SIGNOUT
                 */

                String[] itemList = request.getParameterValues("itemList");

                if (action.equals("signout")) {
                    session.invalidate();
                    getServletContext()
                            .getRequestDispatcher("/index.jsp")
                            .forward(request, response);

                } else if (action.equals("save")) {
                    String itemCode = request.getParameter("itemCode");

                    /* Logic for checking itemcode with itemlist
                    boolean exists = false;
                    for (int i = 0; i <= itemList.length; i++) {
                        if (itemCode == itemList[i]) {
                            exists = true;
                        }
                    }
                     */
                    UserProfile userProfile = (UserProfile) session.getAttribute("userProfile");
                    boolean itemAlreadyExists = false;
                    //check if item exists in user profile already, if it does go to profile page
//                    for (int i = 0; i < userProfile.userItems.size(); i++) {//check if item code is in userItems
//                        if (userProfile.userItems.get(i).item.itemCode == itemCode) {
//                            itemAlreadyExists = true;
//                            getServletContext()
//                                    .getRequestDispatcher("/myitems.jsp")
//                                    .forward(request, response);
//                        }
//                    }

                    for (UserItem item : userProfile.userItems) {
                        if (item.item.itemCode.equals(itemCode)) {
                            itemAlreadyExists = true;
                            getServletContext()
                                    .getRequestDispatcher("/myitems.jsp")
                                    .forward(request, response);
                        }
                    }

                    if (itemAlreadyExists == false) {
                        //item, rating, madeit
                        UserItem newUserItem = new UserItem(ItemDB.getItem(itemCode), 0, false);
                        userProfile.addItem(newUserItem);
                        getServletContext()
                                .getRequestDispatcher("/myitems.jsp")
                                .forward(request, response);
                    }

                    getServletContext()
                            .getRequestDispatcher("/index.jsp")
                            .forward(request, response);

                } else if (action.equals("updateProfile")) {

                    getServletContext()
                            .getRequestDispatcher("/index.jsp")
                            .forward(request, response);

                } else if (action.equals("gotofeedback")) {

                    getServletContext()
                            .getRequestDispatcher("/feedback.jsp")
                            .forward(request, response);

                } else if (action.equals("updateRating")) {

                    String itemCode = request.getParameter("itemCode");
                    int rating = Integer.parseInt(request.getParameter("rating"));
                    String madeIt = request.getParameter("madeIt");
                    Boolean madeItB = Boolean.parseBoolean(madeIt);

                    UserProfile userProfile = (UserProfile) session.getAttribute("userProfile");
                    UserItem updateUserItem = new UserItem(ItemDB.getItem(itemCode), rating, madeItB);

                    userProfile.updateItem(updateUserItem, rating, itemCode, madeItB);

                    getServletContext()
                            .getRequestDispatcher("/myitems.jsp")
                            .forward(request, response);

                } else if (action.equals("deleteItem")) {

                    String itemCode = request.getParameter("itemCode");
                    UserProfile userProfile = (UserProfile) session.getAttribute("userProfile");

                    userProfile.removeItem(itemCode);

                    getServletContext()
                            .getRequestDispatcher("/myitems.jsp")
                            .forward(request, response);

                } else if (action.equals("updateFlag")) {

                    getServletContext()
                            .getRequestDispatcher("/index.jsp")
                            .forward(request, response);
                } else {

                    getServletContext()
                            .getRequestDispatcher("/myitems.jsp")
                            .forward(request, response);
                    /*
                        IF WE ARE IN THE ITEM VIEW THERE WILL ONLY BE ONE ITEM
                        GET A LIST OF ITEMS FROM THE ITEM VIEW
                        AND SAVE THEM AS ITEMLIST
                     */

                    //Checks the http request for parameter(s) called “itemCode”
                    //This tells you which item is to be added to (or updated in) the profile.
                    /*
                            REMEMBER THAT USER PROFILE HAS A LIST OF USER ITEMS

                            ITEMCODE TELLS US WHICH ITEM FROM THE VIEW IS TO BE SAVED
                            OR WHICH ITEM SHOULD BE UPDATED.
                     */
//                        String itemCode = request.getParameter("itemCode");
//                        boolean exists = false;
//                        for (int i = 0; i <= itemList.length; i++) {
//                            if (itemCode == itemList[i]) {
//                                exists = true;
//                            }
//                        }
//
//                        /*
//                            IF THIS ITEM IS NOT IN THE ITEM LIST FROM REQUEST PARAM DISPATCH TO PROFILE VIEW
//                         */
//                        if (exists = false) {
//                            getServletContext()
//                                    .getRequestDispatcher("/myitems.jsp")
//                                    .forward(request, response);
//                        } else {
//                            /*
//                                SAVE
//                             */
//                            UserProfile userProfile = (UserProfile) session.getAttribute("userProfile");
//                            boolean itemAlreadyExists = false;
//                            //check if item exists in user profile already, if it does go to profile page
//                            for (int i = 0; i <= userProfile.userItems.size(); i++) {//check if item code is in userItems
//                                if (userProfile.userItems.get(i).item.itemCode == itemCode) {
//                                    itemAlreadyExists = true;
//                                    getServletContext()
//                                            .getRequestDispatcher("/myitems.jsp")
//                                            .forward(request, response);
//                                }
//                            }
//
//                            if (itemAlreadyExists = false) {
//                                //item, rating, madeit
//
//                                //UserItem newUserItem = new UserItem(ItemDB.getItem(itemCode), 0, false);
//                                //userProfile.addItem(newUserItem);
//                                getServletContext()
//                                        .getRequestDispatcher("/myitems.jsp")
//                                        .forward(request, response);
//                            }
//
//                        }
//
//                    }
                }
            }
        }
    } //end processRequest

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
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
