/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Models.Item;
import Sql.Utility;

/**
 *
 * @author small
 */
public class UserItemDB {
	
     public static void addItem(String itemCode, String itemName, String itemCategory, String itemDescription, int itemRating, String imageUrl, String userID, Boolean madeIt, int rating ) {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int intMadeIt;
//        String query = "SELECT * FROM Users "
//                + "WHERE email=? and pass=?";
        String query = "Insert Into UserItems (itemCode, itemName, itemCategory, itemDescription, itemRating, imageUrl, userID, madeIt, rating)"
                + "values (?,?,?,?,?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, itemCode);
            ps.setString(2, itemName);
            ps.setString(3, itemCategory);
            ps.setString(4, itemDescription);
            ps.setInt(5, itemRating);
            ps.setString(6, imageUrl);
            ps.setString(7, userID);
            if(madeIt == true)
            {
                intMadeIt = 1;
            } else {
                intMadeIt = 0;
            }
            ps.setInt(8, intMadeIt);
            ps.setInt(9, rating);
            ps.executeUpdate();
          
        } catch (SQLException e) {
            System.out.println(e);
          
        } finally {
            Utility.closeResultSet(rs);
            Utility.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

   }  
     
     public static void newRating(String itemCode, String itemName, String itemCategory, String itemDescription, int itemRating, String imageUrl, String userID, Boolean madeIt, int rating )  {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int intMadeIt;
//        String query = "SELECT * FROM Users "
//                + "WHERE email=? and pass=?";
        String query = "Insert Into UserItems (itemCode, itemName, itemCategory, itemDescription, itemRating, imageUrl, userID, madeIt, rating)"
                + "values (?,?,?,?,?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, itemCode);
            ps.setString(2, itemName);
            ps.setString(3, itemCategory);
            ps.setString(4, itemDescription);
            ps.setInt(5, itemRating);
            ps.setString(6, imageUrl);
            ps.setString(7, userID);
            if(madeIt == true)
            {
                intMadeIt = 1;
            } else {
                intMadeIt = 0;
            }
            ps.setInt(8, intMadeIt);
            ps.setInt(9, rating);
            ps.executeUpdate();
          
        } catch (SQLException e) {
            System.out.println(e);
          
        } finally {
            Utility.closeResultSet(rs);
            Utility.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

   }  
     
     public static void updatePaper(String itemName, String itemCategory, String itemDescription, int itemRating, String imageUrl, Boolean madeIt, int rating, String itemCode, String userID) {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
   
//        String query = "SELECT * FROM Users "
//                + "WHERE email=? and pass=?";
        String query = "UPDATE useritems SET itemName=?, itemCategory=?, itemDescription=?, itemRating=?, imageUrl=?, madeIt=?, rating=? WHERE itemCode = ? AND userID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, itemName);
            ps.setString(2, itemCategory);
            ps.setString(3, itemDescription);
            ps.setInt(4, itemRating);
            ps.setString(5, imageUrl);
            ps.setBoolean(6, madeIt);
            ps.setInt(7, rating);
            ps.setString(8, itemCode);
            ps.setString(9, userID);
          
            ps.executeUpdate();
          
        } catch (SQLException e) {
            System.out.println(e);
          
        } finally {
            Utility.closeResultSet(rs);
            Utility.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

   }  
   
     
     public static void updateRating(String itemName, String itemCategory, String itemDescription, int itemRating, String imageUrl, Boolean madeIt, int rating, String itemCode, String userID) {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
   
//        String query = "SELECT * FROM Users "
//                + "WHERE email=? and pass=?";
        String query = "UPDATE useritems SET itemName=?, itemCategory=?, itemDescription=?, itemRating=?, imageUrl=?, madeIt=?, rating=? WHERE itemCode = ? AND userID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, itemName);
            ps.setString(2, itemCategory);
            ps.setString(3, itemDescription);
            ps.setInt(4, itemRating);
            ps.setString(5, imageUrl);
            ps.setBoolean(6, madeIt);
            ps.setInt(7, rating);
            ps.setString(8, itemCode);
            ps.setString(9, userID);
          
            ps.executeUpdate();
          
        } catch (SQLException e) {
            System.out.println(e);
          
        } finally {
            Utility.closeResultSet(rs);
            Utility.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

   }  
     
      public static void updateRatingforOwner(String itemCode, int rating) {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
   
//        String query = "SELECT * FROM Users "
//                + "WHERE email=? and pass=?";
        String query = "UPDATE useritems SET rating=? WHERE itemCode = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, itemCode);
            ps.setInt(2, rating);

          
            ps.executeUpdate();
          
        } catch (SQLException e) {
            System.out.println(e);
          
        } finally {
            Utility.closeResultSet(rs);
            Utility.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

   }  
     public static void deleteItem(String itemCode, String userID) {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int counter = 0;

        String query = "DELETE FROM useritems WHERE itemCode=? and userID=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, itemCode);
            ps.setString(2, userID);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);

        } finally {
            Utility.closeResultSet(rs);
            Utility.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

   }  
}
