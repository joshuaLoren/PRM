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
    
}




