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
import Data.ConnectionPool;
import Data.UserItemDB;
import Sql.Utility;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.errors.IntrusionException;
import org.owasp.esapi.errors.ValidationException;

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
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        UserProfile userProfile = (UserProfile) session.getAttribute("userProfile");
        String message ="";

        /*
            CHECK TO SEE IF THERE IS A USER
        */
        
        //if there is no user, validate 
        if (session.getAttribute("user") == null || (session.getAttribute("userProfile") == null)) {
            
            String username = null;
            username = request.getParameter("username");
            try {
                ESAPI.validator().getValidInput("User Name",
                        username, "Email", 100, false);
            } catch (ValidationException | IntrusionException | NoClassDefFoundError ex) {
                Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
                message = "Unable to login, please try again";
                request.setAttribute("message", message);
                getServletContext()
                        .getRequestDispatcher("/login.jsp")
                        .forward(request, response);
            }
            String password = null;
            password = request.getParameter("password");
            try {
                ESAPI.validator().getValidInput("Password", password, "SafeString", 100, false);
            } catch (ValidationException | IntrusionException | NoClassDefFoundError ex) {
                Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
                message = "Unable to login, please try again";
                request.setAttribute("message", message);
                getServletContext()
                        .getRequestDispatcher("/login.jsp")
                        .forward(request, response);
            }
            
            user = UserDB.getUserIdByUsernameAndPassword(username,password);
            
            //if user does not exist redirect to login.jsp and display message
            if(user == null) {
                
                message = "Unable to login, please try again";
                request.setAttribute("message", message);
                getServletContext()
                        .getRequestDispatcher("/login.jsp")
                        .forward(request, response);
            }
            
            //user exists, set login to true
            boolean loggedIn = true;
            session.setAttribute("loggedIn", loggedIn);
            session.setAttribute("user", user);
            UserProfile profile = new UserProfile();
            profile.addInitialItems(user.getUserID());
            session.setAttribute("userProfile", profile);

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
            try {
                ESAPI.validator().getValidInput("Action", action, "SafeString", 100, true);
            } catch (ValidationException ex) {
                Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IntrusionException ex) {
                Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
            }

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

                    userProfile = (UserProfile) session.getAttribute("userProfile");
                    boolean itemAlreadyExists = false;

                    //for each determines if item already exists in userProfile
                    
                    for (UserItem item : userProfile.userItems) {
                        if (item.item.itemCode.equals(itemCode)) {
                            itemAlreadyExists = true;
                            getServletContext()
                                    .getRequestDispatcher("/myitems.jsp")
                                    .forward(request, response);
                        }
                    }
                    
                    //if the item does not exist in the userProfile
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
                    
                    String itemCode = request.getParameter("itemCode");
                    request.setAttribute("essay", ItemDB.getItem(itemCode));
                    getServletContext()
                            .getRequestDispatcher("/feedback.jsp")
                            .forward(request, response);
                }else if (action.equals("gotoupdatefeedback")) {

                    String itemCode = request.getParameter("itemCode");
                    request.setAttribute("essay", ItemDB.getItem(itemCode));
                    getServletContext()
                            .getRequestDispatcher("/updatefeedback.jsp")
                            .forward(request, response);
                            
                }else if (action.equals("gotoupdatepaper")) {
                      request.setAttribute("message", message);
                    getServletContext()
                            .getRequestDispatcher("/essayupdate.jsp")
                            .forward(request, response);

                }else if (action.equals("newpaper")) {
                    
                  
                    String title = request.getParameter("title");
                    String category = request.getParameter("category");
                    String description = request.getParameter("body");
                    
                    Boolean madeItB = true;
                    
                    userProfile = (UserProfile) session.getAttribute("userProfile");
                    
                    int rows = ItemDB.getRows();
                    rows++;
                    System.out.println("Rows" + rows);
                    String itemCode = Integer.toString(rows); 
                    //String itemCode, String itemName, String itemCategory, String itemDescription, int itemRating, String imageUrl )
                    Item item = new Item(itemCode, title, category, description, 0, "image1.jpeg");
                    ItemDB.addItem(itemCode, title, category, description, 0, "image1.jpeg");
                    // (itemCode, itemName, itemCategory, itemDescription, itemRating, imageUrl, userID, madeIt, rating)"
                    UserItemDB.addItem(itemCode, title, category, description, 0, "image1.jpeg", user.getUserID(), true, 0);
                    System.out.println(itemCode + title + category + description);
                    
                    //UserItem is going to need to take itemcode, cetegory, and item description as parameters
                    // public UserItem(Item item, int rating, boolean madeIt) {
                    UserItem userItem = new UserItem(item, 0, true);
                    //UserProfile can take useritem as parameter
                    userProfile.addItem(userItem);

       
                    getServletContext()
                            .getRequestDispatcher("/myitems.jsp")
                            .forward(request, response); 
                } else if (action.equals("updatepaper")) {
                   

                    String itemCode = request.getParameter("itemCode");
                    String title = request.getParameter("title");
                    String category = request.getParameter("category");
                    String description = request.getParameter("body");
                   
                    
                    userProfile = (UserProfile) session.getAttribute("userProfile");
                    //String itemCode, String itemName, String itemCategory, String itemDescription, int itemRating, String imageUrl )
                    Item item = new Item(itemCode, title, category, description, 0, "image1.jpeg");
                    //(String itemName, String itemCategory, String itemDescription, int itemRating, String imageUrl, String itemCode )
                    ItemDB.updatePaper(title, category, description, 0, "image1.jpeg", itemCode);
                    // (itemCode, itemName, itemCategory, itemDescription, itemRating, imageUrl, userID, madeIt, rating)"
                    UserItemDB.updatePaper(title, category, description, 0, "image1.jpeg",true, 0, itemCode, user.getUserID());
                    
                    System.out.println(itemCode + title + category + description);
                    
                    userProfile.emptyProfile();
                    userProfile.addInitialItems(user.getUserID());
                    //UserItem is going to need to take itemcode, cetegory, and item description as parameters
                    // public UserItem(Item item, int rating, boolean madeIt) {
                    //userProfile.updateItemById(user.getUserID(), itemCode);
                    
                    
                    //UserItem updateUserPaper = new UserItem(ItemDB.getItem(itemCode), rating, madeItB);
                    //userProfile.updateItem(updateUserItem, rating, itemCode, madeItB);
                    //UserItem userItem = new UserItem(item, 0, true);
                    //UserProfile can take useritem as parameter
                    //userProfile.updatePaper(updateUserPaper, rating, itemCode, madeItB);

       
                    getServletContext()
                            .getRequestDispatcher("/myitems.jsp")
                            .forward(request, response); 
                      
             
                
                } else if (action.equals("newRating")) {

//                                <input type="hidden" name="description" value="${essay.itemDescription}">
//                    <input type="hidden" name="rating" value="${essay.itemRating}">
//                    <input type="hidden" name="rating" value="${essay.imageUrl}">
                    
                    String itemCode = request.getParameter("itemCode");
                    String category = request.getParameter("category");
                    String title = request.getParameter("title");
                    String description = request.getParameter("description");
                    int rating = Integer.parseInt(request.getParameter("rating"));
                    String url = request.getParameter("url");
                    System.out.println(itemCode);
                   
                    String madeIt = request.getParameter("madeIt");
                    Boolean madeItB = Boolean.parseBoolean(madeIt);

                    
                    //String itemCode, String itemName, String itemCategory, String itemDescription, int itemRating, String imageUrl, String userID, Boolean madeIt, int rating )  {
                    UserItemDB.newRating(itemCode, title, category, description, rating, "image1.jpeg", user.getUserID(), false, 0);
                    
                    //ItemDB.newRating(title, category, description, 0, "image1.jpeg", itemCode);
                    userProfile = (UserProfile) session.getAttribute("userProfile");
                    UserItem updateUserItem = new UserItem(ItemDB.getItem(itemCode), rating, false);
                    userProfile.addItem(updateUserItem);

                    getServletContext()
                            .getRequestDispatcher("/myitems.jsp")
                            .forward(request, response);
                }else if (action.equals("updateRating")) {

                    String itemCode = request.getParameter("itemCode");
                    String category = request.getParameter("category");
                    String title = request.getParameter("title");
                    String description = request.getParameter("description");
                    int rating = Integer.parseInt(request.getParameter("rating"));
                    String url = request.getParameter("url");
                    System.out.println(itemCode);
                  
                    String madeIt = request.getParameter("madeIt");
                    Boolean madeItB = Boolean.parseBoolean(madeIt);

                    
                    UserItemDB.updateRating(title, category, description, 0, "image1.jpeg",false, 0, itemCode, user.getUserID());
                    ItemDB.updateRating(title, category, description, 0, "image1.jpeg", itemCode);
                    UserItemDB.updateRatingforOwner(itemCode, rating);
                    ItemDB.updateRatingforOwner(itemCode, rating);
                    userProfile = (UserProfile) session.getAttribute("userProfile");
                    UserItem updateUserItem = new UserItem(ItemDB.getItem(itemCode), rating, false);
                    userProfile.updateItem(updateUserItem, rating, itemCode, false);

                    getServletContext()
                            .getRequestDispatcher("/myitems.jsp")
                            .forward(request, response);

                } else if (action.equals("deleteItem")) {

                    String itemCode = request.getParameter("itemCode");
                    userProfile = (UserProfile) session.getAttribute("userProfile");

                    UserItemDB.deleteItem(itemCode, user.getUserID());
                    ItemDB.deleteItem(itemCode);
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
