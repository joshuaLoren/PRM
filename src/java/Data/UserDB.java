/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Models.User;
import Models.UserProfile;
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
public class UserDB {


    public static ArrayList<User> getItems() {
    	
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> users = new ArrayList<>();

        String query = "SELECT * FROM Users";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            User user = null;
            while (rs.next()) {
                user = new User();
                user.setUserID(rs.getString("userID"));
                user.setPassword(rs.getString("pass"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            Utility.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static User getUser(String id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Users "
                + "WHERE userID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            User user = null;
            if (rs.next()) {
                user = new User();
                user.setUserID(rs.getString("userID"));
                user.setPassword("pass");
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
            }
            return user;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            Utility.closeResultSet(rs);
            Utility.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
     public static User getUserIdByUsernameAndPassword(String email, String password) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Users "
                + "WHERE email=? and pass=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            User user = null;
            if (rs.next()) {
                user = new User();
                user.setUserID(rs.getString("userID"));
                user.setPassword("pass");
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
            }
            return user;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            Utility.closeResultSet(rs);
            Utility.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
     
      public static void addUser(String userID, String pass, String first_name, String last_name, String email) {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        


        
        String query = "Insert Into Users (userID, pass, first_name, last_name, email)"
                + "values (?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, userID);
            ps.setString(2, pass);
            ps.setString(3, first_name);
            ps.setString(4, last_name);
            ps.setString(5, email);
  
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

        String query = "SELECT COUNT(*) from Users ";
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
      
}
