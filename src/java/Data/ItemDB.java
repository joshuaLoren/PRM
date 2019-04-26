/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Models.Item;
import Models.User;
import Sql.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author small
 */
public class ItemDB {


    public static ArrayList<Item> getItems() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Item> items = new ArrayList<>();

        String query = "SELECT * FROM Items";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            Item item = null;
            while (rs.next()) {
                item = new Item();
                item.setItemCode(rs.getString("itemCode"));
                item.setItemName(rs.getString("itemName"));
                item.setItemCategory(rs.getString("itemCategory"));
                item.setItemDescription(rs.getString("itemDescription"));
                item.setItemRating(rs.getInt("itemRating"));
                item.setUrl(rs.getString("imageUrl"));
                items.add(item);
            }
            return items;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            Utility.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    
    public static ArrayList<Item> getItemsById() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Item> items = new ArrayList<>();

        String query = "SELECT * FROM Items";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            Item item = null;
            while (rs.next()) {
                item = new Item();
                item.setItemCode(rs.getString("itemCode"));
                item.setItemName(rs.getString("itemName"));
                item.setItemCategory(rs.getString("itemCategory"));
                item.setItemDescription(rs.getString("itemDescription"));
                item.setItemRating(rs.getInt("itemRating"));
                item.setUrl(rs.getString("imageUrl"));
                items.add(item);
            }
            return items;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            Utility.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }


    public ArrayList<Item> getNarrative() {
    	ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Item> items = new ArrayList<>();

        String query = "SELECT * FROM Items "
                + "WHERE itemCategory = ?";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, "narrative");
            rs = ps.executeQuery();
            Item item = null;
            while (rs.next()) {
                item = new Item();
                item.setItemCode(rs.getString("itemCode"));
                item.setItemName(rs.getString("itemName"));
                item.setItemCategory(rs.getString("itemCategory"));
                item.setItemDescription(rs.getString("itemDescription"));
                item.setItemRating(rs.getInt("itemRating"));
                item.setUrl(rs.getString("imageUrl"));
                items.add(item);
            }
            return items;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            Utility.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public ArrayList<Item> getPersuasive() {
    	ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Item> items = new ArrayList<>();

        String query = "SELECT * FROM Items "
                + "WHERE itemCategory = ?";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, "persuasive");
            rs = ps.executeQuery();
            Item item = null;
            while (rs.next()) {
                item = new Item();
                item.setItemCode(rs.getString("itemCode"));
                item.setItemName(rs.getString("itemName"));
                item.setItemCategory(rs.getString("itemCategory"));
                item.setItemDescription(rs.getString("itemDescription"));
                item.setItemRating(rs.getInt("itemRating"));
                item.setUrl(rs.getString("imageUrl"));
                items.add(item);
            }
            return items;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            Utility.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    
    public ArrayList<Item> getExpository() {
    	ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Item> items = new ArrayList<>();

        String query = "SELECT * FROM Items "
                + "WHERE itemCategory = ?";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, "expository");
            rs = ps.executeQuery();
            Item item = null;
            while (rs.next()) {
                item = new Item();
                item.setItemCode(rs.getString("itemCode"));
                item.setItemName(rs.getString("itemName"));
                item.setItemCategory(rs.getString("itemCategory"));
                item.setItemDescription(rs.getString("itemDescription"));
                item.setItemRating(rs.getInt("itemRating"));
                item.setUrl(rs.getString("imageUrl"));
                items.add(item);
            }
            return items;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            Utility.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }


    public static Item getItem(String itemCode) {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Items "
                + "WHERE itemCode = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, itemCode);
            rs = ps.executeQuery();
            Item item = null;
            if (rs.next()) {
                item = new Item();
                item.setItemCode(rs.getString("itemCode"));
                item.setItemName(rs.getString("itemName"));
                item.setItemCategory(rs.getString("itemCategory"));
                item.setItemDescription(rs.getString("itemDescription"));
                item.setItemRating(rs.getInt("itemRating"));
                item.setUrl(rs.getString("imageUrl"));
            }
            return item;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            Utility.closeResultSet(rs);
            Utility.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

   }  
    
   public static void addItem(String itemCode, String itemName, String itemCategory, String itemDescription, int itemRating, String imageUrl ) {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
//        String query = "SELECT * FROM Users "
//                + "WHERE email=? and pass=?";
        String query = "Insert Into Items (itemCode, itemName, itemCategory, itemDescription, itemRating, imageUrl)"
                + "values (?,?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, itemCode);
            ps.setString(2, itemName);
            ps.setString(3, itemCategory);
            ps.setString(4, itemDescription);
            ps.setInt(5, itemRating);
            ps.setString(6, imageUrl);
            ps.executeUpdate();
          
        } catch (SQLException e) {
            System.out.println(e);
          
        } finally {
            Utility.closeResultSet(rs);
            Utility.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

   }  
   
   public static void updatePaper(String itemName, String itemCategory, String itemDescription, int itemRating, String imageUrl, String itemCode ) {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
//        String query = "SELECT * FROM Users "
//                + "WHERE email=? and pass=?";
        String query = "UPDATE Items SET itemName=?, itemCategory=?, itemDescription=?, itemRating=?, imageUrl=? WHERE itemCode = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, itemName);
            ps.setString(2, itemCategory);
            ps.setString(3, itemDescription);
            ps.setInt(4, itemRating);
            ps.setString(5, imageUrl);
            ps.setString(6, itemCode);
            ps.executeUpdate();
          
        } catch (SQLException e) {
            System.out.println(e);
          
        } finally {
            Utility.closeResultSet(rs);
            Utility.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

   }  
   
      
       public static int getRows() {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int counter = 0;

        String query = "SELECT COUNT(*) from Items ";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery(query);
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(e);
            return -1;
        } finally {
            Utility.closeResultSet(rs);
            Utility.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

   }  
    
   public static void deleteItem(String itemCode) {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int counter = 0;

        String query = "DELETE FROM items WHERE itemCode=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, itemCode);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);

        } finally {
            Utility.closeResultSet(rs);
            Utility.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

   }  
   
//    public static void newRating(String itemCode, String itemName, String itemCategory, int itemRating) {
//
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        int intMadeIt;
////        String query = "SELECT * FROM Users "
////                + "WHERE email=? and pass=?";
//        String query = "Insert Into UserItems (itemCode, itemName, itemCategory, itemDescription, itemRating, imageUrl, userID, madeIt, rating)"
//                + "values (?,?,?,?,?,?,?,?,?)";
//        try {
//            ps = connection.prepareStatement(query);
//            ps.setString(1, itemCode);
//            ps.setString(2, itemName);
//            ps.setString(3, itemCategory);
//            ps.setString(4, itemDescription);
//            ps.setInt(5, itemRating);
//            ps.setString(6, imageUrl);
//            ps.setString(7, userID);
//            if(madeIt == true)
//            {
//                intMadeIt = 1;
//            } else {
//                intMadeIt = 0;
//            }
//            ps.setInt(8, intMadeIt);
//            ps.setInt(9, rating);
//            ps.executeUpdate();
//          
//        } catch (SQLException e) {
//            System.out.println(e);
//          
//        } finally {
//            Utility.closeResultSet(rs);
//            Utility.closePreparedStatement(ps);
//            pool.freeConnection(connection);
//        }
//
//   }  
     public static void updateRating(String itemName, String itemCategory, String itemDescription, int itemRating, String imageUrl, String itemCode ) {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
//        String query = "SELECT * FROM Users "
//                + "WHERE email=? and pass=?";
        String query = "UPDATE Items SET itemName=?, itemCategory=?, itemDescription=?, itemRating=?, imageUrl=? WHERE itemCode = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, itemName);
            ps.setString(2, itemCategory);
            ps.setString(3, itemDescription);
            ps.setInt(4, itemRating);
            ps.setString(5, imageUrl);
            ps.setString(6, itemCode);
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
        String query = "UPDATE items SET rating=? WHERE itemCode = ?";
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
   
   
}




